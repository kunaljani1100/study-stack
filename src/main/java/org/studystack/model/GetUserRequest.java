package org.studystack.model;

import lombok.Data;

/**
 * The model for a request to get user information based on the username.
 */
@Data
public class GetUserRequest {

    /**
     * The username for which the user information is requested.
     */
    private String username;
}
