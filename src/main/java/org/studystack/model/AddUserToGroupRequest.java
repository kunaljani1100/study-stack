package org.studystack.model;

/**
 * This class models the addition of a user to a group.
 */
public class AddUserToGroupRequest {

    /**
     * The username of the individual who wants to be a member of a group.
     */
    private String username;

    /**
     * The group identifier for the group the user wants to join.
     */
    private String groupId;

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
}
