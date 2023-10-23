package org.students.ninjas.entity.factory;

import lombok.AllArgsConstructor;
import org.students.ninjas.entity.BaseEntity;
import org.students.ninjas.entity.User;

import java.time.LocalDateTime;

@AllArgsConstructor
public class UserFactory implements AbstractBaseEntityFactory {
    private int id;
    private LocalDateTime createdAt;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String phoneNumber;
    private LocalDateTime lastOnline;
    private boolean isOnline;
    @Override
    public BaseEntity createEntity() {
        return new User(id, createdAt, firstName, lastName, email, username, phoneNumber, lastOnline, isOnline);
    }
}
