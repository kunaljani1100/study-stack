package org.studystack.model;

import lombok.Data;

@Data
public class Question {

    /**
     * The identifier used to identify a question asked by a particular user in a group.
     */
    private String questionId;

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
