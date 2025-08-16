package org.studystack.model;

import lombok.Data;

import java.util.List;

@Data
public class GetAnswersForQuestionBatchRequest {

    private List<String> questionIds;
}
