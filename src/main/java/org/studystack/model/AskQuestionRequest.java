package org.studystack.model;

import lombok.Data;

/**
 * The model for a question that a user has posted.
 */
@Data
public class AskQuestionRequest {

    /**
     * The username of a user who has posted the question.
     */
    private String username;

    /**
     * The group ID in which the user has posted the question.
     */
    private String groupId;

    /**
     * The question the user has posted.
     */
    private String question;
}
