package org.students.ninjas.entity.factory;

import lombok.AllArgsConstructor;
import org.students.ninjas.entity.BaseEntity;
import org.students.ninjas.entity.User;

import java.time.LocalDateTime;

/**
 * The type User factory creating a Message entity
 */
@AllArgsConstructor
public class UserFactory implements AbstractBaseEntityFactory {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String phoneNumber;
    private LocalDateTime lastOnline;
    private boolean isOnline;

    @Override
    public BaseEntity createEntity() {
        return new User(firstName, lastName, email, username, phoneNumber, lastOnline, isOnline);
    }
}
