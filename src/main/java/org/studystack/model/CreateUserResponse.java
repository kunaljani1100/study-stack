package org.studystack.model;

/**
 * This class specifies the username of the new user that is created in the user response.
 */
public class CreateUserResponse {

    /**
     * The newly created username assigned to the user.
     */
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
