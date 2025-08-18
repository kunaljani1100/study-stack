package org.studystack.model;

import lombok.Data;

/**
 * The model for a response when a user has been authenticated.
 */
@Data
public class AuthenticateUserResponse {

    /**
     * The username of the user who has been authenticated.
     */
    private String result;
}
