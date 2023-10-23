package org.students.ninjas.repository;

import org.students.ninjas.entity.User;

public interface UserRepository {
    User getUserById(int id);
    User deleteUserById(int id);
    User addUser(User user);

}
