package org.studystack.database.entity;

import java.util.List;

/**
 * This class specifies the group on studystack that consists of multiple users.
 */
public class GroupEntity {

    /**
     * The identifier that is used to uniquely identify a group.
     */
    private String groupId;

    /**
     * The plain text name of the group that is easily understandable by the users in English language.
     */
    private String groupName;

    /**
     * The list of all the usernames that are associated with this group.
     */
    private List<String> usernames;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }
}
