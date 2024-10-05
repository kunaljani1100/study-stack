package org.studystack.model;

/**
 * This class models the request for viewing users in a particular group.
 */
public class ViewUsersInGroupRequest {

    /**
     * The group ID for which we want to view the active members.
     */
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
