package org.students.ninjas.repository;

import org.students.ninjas.entity.User;

import java.util.HashMap;

/**
 * The type User repository.
 */
public class UserRepositoryImpl implements UserRepository {
    /**
     * The database mock implemented as HashMap.
     */
    private static final HashMap<Integer, User> users = new HashMap<>();
    private static int id = 0;

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }

    @Override
    public User deleteUserById(int id) {
        return users.remove(id);
    }

    /**
     * Adding User to the mock database incrementing id
     */
    @Override
    public User addUser(User user) {
        ++id;
        user.setId(id);
        users.put(id, user);
        return user;
    }
}
