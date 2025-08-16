package org.studystack.model;

import lombok.Data;

import java.util.List;

@Data
public class GetAnswersForQuestionBatchResponse {
    private List<Answer> answers;
}
