package org.students.ninjas.firstTask.repository;

import org.students.ninjas.firstTask.entity.Message;

import java.util.HashMap;

/**
 * The type Message repository.
 */
public class MessageRepositoryImpl implements MessageRepository {

    /**
     * The database mock implemented as HashMap.
     */
    private static final HashMap<Integer, Message> messages = new HashMap<>();
    private static int id = 0;

    @Override
    public Message getMessageById(int id) {
        return messages.get(id);
    }

    @Override
    public Message deleteMessageById(int id) {
        return messages.remove(id);
    }

    /**
     * Adding Message to the mock database incrementing id
     */
    @Override
    public Message addMessage(Message message) {
        ++id;
        message.setId(id);
        messages.put(id, message);
        return message;
    }
}
