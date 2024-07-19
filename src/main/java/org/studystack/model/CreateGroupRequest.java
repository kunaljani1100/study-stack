package org.studystack.model;

/**
 * This class specified the fields that are required to create a new group in the database.
 */
public class CreateGroupRequest {

    /**
     * The name of the studystack group, this group is not necessarily unique.
     */
    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
