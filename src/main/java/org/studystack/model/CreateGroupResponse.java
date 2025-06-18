package org.studystack.model;

import lombok.Data;

/**
 * This group specifies the group ID that was generated for the newly created group in the database.
 */
@Data
public class CreateGroupResponse {

    /**
     * The identifier that is uniquely used to identify the name of the group.
     */
    private String groupId;
}
