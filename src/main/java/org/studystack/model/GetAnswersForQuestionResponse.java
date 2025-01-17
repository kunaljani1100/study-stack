package org.studystack.model;

import org.bson.Document;

import java.util.List;

public class GetAnswersForQuestionResponse {

    private List<Answer> answers;

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
