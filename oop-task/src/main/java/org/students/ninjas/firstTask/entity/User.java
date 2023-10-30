package org.students.ninjas.firstTask.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * The type User extended from BaseEntity
 */
@Getter
@Setter
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String phoneNumber;
    private LocalDateTime lastOnline;
    private boolean isOnline;

    /**
     * Instantiates a new User.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param email       the email
     * @param username    the username
     * @param phoneNumber the phone number
     * @param lastOnline  the last online
     * @param isOnline    the is online
     */
    public User(String firstName, String lastName, String email, String username, String phoneNumber, LocalDateTime lastOnline, boolean isOnline) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.lastOnline = lastOnline;
        this.isOnline = isOnline;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", lastOnline=" + lastOnline +
                ", isOnline=" + isOnline +
                '}';
    }
}
