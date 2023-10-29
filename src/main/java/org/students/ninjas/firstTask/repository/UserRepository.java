package org.students.ninjas.firstTask.repository;

import org.students.ninjas.firstTask.entity.User;

/**
 * The interface User repository.
 */
public interface UserRepository {
    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    User getUserById(int id);

    /**
     * Delete user by id.
     *
     * @param id the id
     * @return the user
     */
    User deleteUserById(int id);

    /**
     * Add user to repository.
     *
     * @param user the user
     * @return the user
     */
    User addUser(User user);

}
