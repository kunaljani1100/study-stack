package org.studystack.model;

import lombok.Data;

/**
 * The model for an answer that a user has given for a particular question.
 */
@Data
public class Answer {

    /**
     * The question ID for which this answer has been given.
     */
    private String questionId;

    /**
     * The username of the user who has answered the question.
     */
    private String username;

    /**
     * The answer that has been given for a particular question.
     */
    private String answer;

    /**
     * The accuracy of the answer provided by the user.
     */
    private double accuracy;
}
