package org.studystack.model;

import lombok.Data;

/**
 * This class specifies the fields that are required to create a new user in the database.
 */
@Data
public class CreateUserRequest {

    /**
     * The first name of the user.
     */
    private String firstName;

    /**
     * The middle name of the user.
     */
    private String middleName;

    /**
     * The last name of the user.
     */
    private String lastName;

    /**
     * The 10-digit phone number of the user.
     */
    private String phoneNumber;

    /**
     * The email address of the user.
     */
    private String emailAddress;

    /**
     * The username that the user uses at the time of login.
     */
    private String username;

    /**
     * The password the user uses at the time of login.
     */
    private String password;

    /**
     * Indicates whether the user prefers to receive texts.
     */
    private Boolean textingIndicator;

    /**
     * Indicates whether the user prefers to receive email notifications.
     */
    private Boolean emailIndicator;
}
