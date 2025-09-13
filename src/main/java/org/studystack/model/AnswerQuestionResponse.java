package org.studystack.model;

import lombok.Data;

/**
 * The model for the response when a user has answered a question.
 * It contains the identifier of the answer that was created.
 */
@Data
public class AnswerQuestionResponse {

    /**
     * The identifier for the answer that has been created.
     */
    private String answerId;

    /**
     * The accuracy for the answer that has been created.
     */
    private double accuracy;
}
