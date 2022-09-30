package com.springbank.user.query.api.dto;

import com.springbank.user.core.dto.BaseResponse;
import com.springbank.user.core.models.User;

import java.util.List;

public class UserLookupResponse extends BaseResponse {
    private List<User> users;

    public UserLookupResponse(String message) {
        super(message);
    }

    public UserLookupResponse(String message, List<User> users) {
        super(message);
        this.users = users;
    }

    public UserLookupResponse(String message, User user) {
        super(message);
        this.users = List.of(user);
    }

    public UserLookupResponse(List<User> users) {
        super(null);
        this.users = users;
    }

    public UserLookupResponse(User user) {
        super(null);
        this.users = List.of(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
