package org.studystack.model;

/**
 * The response returned when a question has been posted in a group.
 */
public class AskQuestionResponse {

    /**
     * The identifier that is corresponding to the question that is being asked.
     */
    private String questionId;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
}
