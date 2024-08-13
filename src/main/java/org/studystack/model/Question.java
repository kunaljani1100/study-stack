package org.studystack.model;

import java.util.List;

/**
 * The model for a question that a user has posted.
 */
public class Question {

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

    /**
     * The list of all the answers that has been provided for a particular question.
     */
    private List<Answer> answers;

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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
