package com.springbank.user.cmd.api.controllers;

import com.springbank.user.cmd.api.commands.RegisterUserCommand;
import com.springbank.user.cmd.api.dto.RegisterUserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/registerUser")
public class RegisterUserController {
    private final CommandGateway commandGateway;

    @PostMapping
    @PreAuthorize(value = "hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<RegisterUserResponse> registerUser(@Valid @RequestBody RegisterUserCommand command) {
        var id = UUID.randomUUID().toString();
        command.setId(id);

        try {
            commandGateway.sendAndWait(command);

            return new ResponseEntity<>(new RegisterUserResponse(id, "User successfully registered!"), HttpStatus.CREATED);
        } catch (Exception e) {
            var safeErrorMessage = "Error while processing register user request for id - " + id;
            log.error(e.toString());

            return new ResponseEntity<>(new RegisterUserResponse(id, safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
