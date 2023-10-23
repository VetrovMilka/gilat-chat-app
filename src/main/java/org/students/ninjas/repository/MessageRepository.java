package org.students.ninjas.repository;

import org.students.ninjas.entity.Message;

public interface MessageRepository {
    Message getMessageById(int id);
    Message deleteMessageById(int id);
    Message addMessage(Message message);

}
