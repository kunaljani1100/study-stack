package org.studystack.model;

import lombok.Data;

/**
 * This class specified the fields that are required to create a new group in the database.
 */
@Data
public class CreateGroupRequest {

    /**
     * The name of the studystack group, this group is not necessarily unique.
     */
    private String groupName;
}
