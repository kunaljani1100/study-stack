package org.studystack.model;

import lombok.Data;

@Data
public class AnswerQuestionRequest {

    private String answer;

    private String questionId;

    private String username;
}
