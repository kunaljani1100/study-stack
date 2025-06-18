package org.studystack.model;

import lombok.Data;

/**
 * This class specifies the username of the new user that is created in the user response.
 */
@Data
public class CreateUserResponse {

    /**
     * The newly created username assigned to the user.
     */
    private String username;
}
