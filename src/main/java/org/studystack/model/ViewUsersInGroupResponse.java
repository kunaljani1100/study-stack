package org.studystack.model;

import lombok.Data;

import java.util.List;

/**
 * This class models the response for the list of users that are present in a stadystack group.
 */
@Data
public class ViewUsersInGroupResponse {

    /**
     * The name of the group that was queried.
     */
    private String groupName;

    /**
     * The list of users that are present in the group.
     */
    private List<UserInGroup> users;
}
