package org.studystack.model;

import lombok.Data;

/**
 * The model for the user in a particular group.
 */
@Data
public class UserInGroup {

    /**
     * The username to be returned to the user
     */
    private String username;

    /**
     * The firstname of the group member.
     */
    private String firstName;

    /**
     * The middlename of the group member.
     */
    private String middleName;

    /**
     * The lastname of the group member.
     */
    private String lastName;
}
