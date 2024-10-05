package org.studystack.model;

/**
 * The model for the user in a particular group.
 */
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
