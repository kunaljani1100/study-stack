package org.studystack.model;

public class Question {

    /**
     * The identifier used to identify a question asked by a particular user in a group.
     */
    private String questionId;

    /**
     * The username of a user who has posted the question.
     */
    private String username;

    /**
     * The group ID in which the user has posted the question.
     */
    private String groupId;

    /**
     * The question the user has posted.
     */
    private String question;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
