package org.studystack.database.entity;

public class AnswerEntity {

    /**
     * The identifier used to identify the answer that the user has responded for a question.
     */
    private String answerId;

    /**
     * The answer provided by the user for a question.
     */
    private String answer;

    /**
     * The username who has answered the question.
     */
    private String username;

    /**
     * The question identifier for a question.
     */
    private String questionId;

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
}
