package org.studystack.model;

import lombok.Data;

/**
 * This class models the request for viewing users in a particular group.
 */
@Data
public class ViewUsersInGroupRequest {

    /**
     * The group ID for which we want to view the active members.
     */
    private String groupId;
}
