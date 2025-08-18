package org.studystack.model;

import lombok.Data;

import java.util.List;

/**
 * The model for a request to get answers for a batch of questions.
 */
@Data
public class GetAnswersForQuestionBatchRequest {

    /**
     * The group ID for which the answers are requested.
     */
    private List<String> questionIds;
}
