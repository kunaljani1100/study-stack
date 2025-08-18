package org.studystack.model;

import lombok.Data;

/**
 * The model for a request to authenticate a user.
 */
@Data
public class AuthenticateUserRequest {

    /**
     * The username of the user trying to authenticate.
     */
    private String username;

    /**
     * The password of the user trying to authenticate.
     */
    private String password;
}
