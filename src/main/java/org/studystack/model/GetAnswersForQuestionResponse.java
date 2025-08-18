package org.studystack.model;

import lombok.Data;

import java.util.List;

/**
 * The model for a response containing answers for a specific question.
 */
@Data
public class GetAnswersForQuestionResponse {

    /**
     * The list of answers corresponding to the question.
     */
    private List<Answer> answers;
}
