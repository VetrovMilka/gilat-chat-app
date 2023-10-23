package org.students.ninjas.repository;

import org.students.ninjas.entity.User;

import java.util.HashMap;

public class UserRepositoryImpl implements UserRepository{

    private static final HashMap<Integer, User> users = new HashMap<>();
    @Override
    public User getUserById(int id) {
        return users.get(id);
    }

    @Override
    public User deleteUserById(int id) {
        return users.remove(id);
    }

    @Override
    public User addUser(User user) {
        users.put(user.getId(), user);
        return user;
    }
}
