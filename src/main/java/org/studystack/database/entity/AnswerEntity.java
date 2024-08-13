package org.studystack.database.entity;

public class AnswerEntity {

    /**
     * The username of the user who has answered the question.
     */
    private String username;

    /**
     * The answer that has been given for a particular question.
     */
    private String answer;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
