package org.studystack.model;

import lombok.Data;

@Data
public class AuthenticateUserRequest {

    private String username;

    private String password;
}
