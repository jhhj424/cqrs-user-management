package com.springbank.user.cmd.api.commands;

import com.springbank.user.core.models.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class UpdateUserCommand {
    @TargetAggregateIdentifier
    private String id;
    @NotNull(message = "사용자 세부 정보가 제공되지 않았습니다.")
    @Valid
    private User user;
}
