package org.studystack.database.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * This class represents an answer entity in the StudyStack application.
 * It contains details about an answer provided by a user for a specific question,
 * including the answer text, the user who answered, and the question identifier.
 */
@Getter
@Setter
public class AnswerEntity {

    /**
     * The identifier used to identify the answer that the user has responded for a question.
     */
    private String answerId;

    /**
     * The answer provided by the user for a question.
     */
    private String answer;

    /**
     * The username who has answered the question.
     */
    private String username;

    /**
     * The question identifier for a question.
     */
    private String questionId;

    /**
     * The accuracy for the answer provided by the user.
     */
     private double accuracy;
}
