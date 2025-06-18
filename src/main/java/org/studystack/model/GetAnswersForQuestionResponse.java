package org.studystack.model;

import lombok.Data;

import java.util.List;

@Data
public class GetAnswersForQuestionResponse {

    private List<Answer> answers;
}
