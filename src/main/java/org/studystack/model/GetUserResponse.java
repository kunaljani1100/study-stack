package org.studystack.model;

import lombok.Data;
import org.studystack.database.entity.QuestionEntity;

import java.util.List;

/**
 * The model for a response when retrieving user details.
 */
@Data
public class GetUserResponse {

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

    /**
     * Specifies the list of group IDs the user is a member of.
     */
    private List<String> groups;

    /**
     * Specifies the list of questions that the user has posted in a group.
     */
    private List<QuestionEntity> questions;
}
