package org.students.ninjas.repository;

import org.students.ninjas.entity.Message;

import java.util.HashMap;

public class MessageRepositoryImpl implements MessageRepository{

    private static final HashMap<Integer, Message> messages = new HashMap<>();

    @Override
    public Message getMessageById(int id) {
        return messages.get(id);
    }

    @Override
    public Message deleteMessageById(int id) {
        return messages.remove(id);
    }

    @Override
    public Message addMessage(Message message) {
        messages.put(message.getId(), message);
        return message;
    }
}
