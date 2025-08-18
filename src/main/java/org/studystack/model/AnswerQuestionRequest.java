package org.studystack.model;

import lombok.Data;

/**
 * This class models the request to answer a question in the StudyStack application.
 * It contains the answer text, the question identifier, and the username of the user answering.
 */
@Data
public class AnswerQuestionRequest {

    /**
     * The answer that the user has provided for a specific question.
     */
    private String answer;

    /**
     * The identifier for the question that the user is answering.
     */
    private String questionId;

    /**
     * The username of the user who is providing the answer.
     */
    private String username;
}
