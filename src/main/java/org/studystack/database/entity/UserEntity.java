package org.studystack.database.entity;

/**
 * This class specified the model for the user who is using the studystack application.
 */
public class UserEntity {

    /**
     * The unique identifier (username) of the user.
     */
    private String _id;

    /**
     * The first name of the user.
     */
    private String firstName;

    /**
     * The middle name of the user.
     */
    private String middleName;

    /**
     * The last name of the user.
     */
    private String lastName;

    /**
     * The 10-digit phone number of the user.
     */
    private String phoneNumber;

    /**
     * The email address of the user.
     */
    private String emailAddress;

    /**
     * The username that the user uses at the time of login.
     */
    private String username;

    /**
     * The password the user uses at the time of login.
     */
    private String password;

    /**
     * Indicates whether the user prefers to receive texts.
     */
    private Boolean textingIndicator;

    /**
     * Indicates whether the user prefers to receive email notifications.
     */
    private Boolean emailIndicator;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getTextingIndicator() {
        return textingIndicator;
    }

    public void setTextingIndicator(Boolean textingIndicator) {
        this.textingIndicator = textingIndicator;
    }

    public Boolean getEmailIndicator() {
        return emailIndicator;
    }

    public void setEmailIndicator(Boolean emailIndicator) {
        this.emailIndicator = emailIndicator;
    }
}
