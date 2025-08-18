package org.studystack.model;

import lombok.Data;

import java.util.List;

/**
 * The model for a response containing answers for a batch of questions.
 */
@Data
public class GetAnswersForQuestionBatchResponse {

    /**
     * The list of answers corresponding to the questions in the batch.
     */
    private List<Answer> answers;
}
