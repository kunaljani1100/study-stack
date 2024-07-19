package org.studystack.model;

/**
 * The model for the response when a user has been added to a group.
 */
public class AddUserToGroupResponse {

    /**
     * The message returned to the user when a user has been successfully been added as a part of a group.
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
