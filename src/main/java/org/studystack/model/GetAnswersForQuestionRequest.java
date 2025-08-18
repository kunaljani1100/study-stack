package org.studystack.model;

import lombok.Data;

/**
 * The model for a request to get answers for a specific question.
 */
@Data
public class GetAnswersForQuestionRequest {

    /**
     * The group ID for which the answers are requested.
     */
    private String questionId;
}
