package org.studystack.model;

import lombok.Data;

/**
 * This class models the addition of a user to a group.
 */
@Data
public class AddUserToGroupRequest {

    /**
     * The username of the individual who wants to be a member of a group.
     */
    private String username;

    /**
     * The group identifier for the group the user wants to join.
     */
    private String groupId;
}
