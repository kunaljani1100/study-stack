package org.studystack.model;

/**
 * This group specifies the group ID that was generated for the newly created group in the database.
 */
public class CreateGroupResponse {

    /**
     * The identifier that is uniquely used to identify the name of the group.
     */
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
