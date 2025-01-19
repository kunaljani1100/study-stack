package org.studystack.model;

public class ViewQuestionsInGroupRequest {

    /**
     * The group ID for which we want to view all the questions that have been asked.
     */
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
