package org.students.ninjas.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
public class User extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String phoneNumber;
    private LocalDateTime lastOnline;
    private boolean isOnline;

    public User(LocalDateTime createdAt, String firstName, String lastName, String email, String username, String phoneNumber, LocalDateTime lastOnline, boolean isOnline) {
        super(createdAt);
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
