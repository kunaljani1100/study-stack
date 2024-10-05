package org.studystack.model;

import java.util.List;

/**
 * This class models the response for the list of users that are present in a stadystack group.
 */
public class ViewUsersInGroupResponse {

    /**
     * The name of the group that was queried.
     */
    private String groupName;

    /**
     * The list of users that are present in the group.
     */
    private List<UserInGroup> users;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<UserInGroup> getUsers() {
        return users;
    }

    public void setUsers(List<UserInGroup> users) {
        this.users = users;
    }
}
