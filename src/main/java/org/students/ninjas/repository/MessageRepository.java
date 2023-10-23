package org.students.ninjas.repository;

import org.students.ninjas.entity.Message;

/**
 * The interface Message repository.
 */
public interface MessageRepository {
    /**
     * Gets message by id.
     *
     * @param id the id
     * @return the message by id
     */
    Message getMessageById(int id);

    /**
     * Delete message by id.
     *
     * @param id the id
     * @return the message
     */
    Message deleteMessageById(int id);

    /**
     * Add message to repository.
     *
     * @param message the message
     * @return the message
     */
    Message addMessage(Message message);

}
