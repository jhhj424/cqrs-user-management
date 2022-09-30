package com.springbank.user.core.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Size(min = 2, message = "사용자 이름은 최소 2자 이상이어야 합니다.")
    private String username;
    @Size(min = 7, message = "비밀번호는 최소 7자 이상이어야 합니다.")
    private String password;
    @NotNull(message = "사용자 역할을 1개 이상 지정")
    private List<Role> roles;
}
