package com.springbank.user.core.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @NotEmpty(message = "이름은 필수입니다")
    private String firstname;
    @NotEmpty(message = "성은 필수입니다")
    private String lastname;
    @Email(message = "유효한 이메일 주소를 입력하세요")
    private String emailAddress;
    @NotNull(message = "계정 자격 증명을 입력하세요")
    private Account account;
}
