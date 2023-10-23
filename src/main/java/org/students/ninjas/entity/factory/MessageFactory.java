package org.students.ninjas.entity.factory;

import lombok.AllArgsConstructor;
import org.students.ninjas.entity.BaseEntity;
import org.students.ninjas.entity.Message;
import org.students.ninjas.entity.User;

import java.time.LocalDateTime;

@AllArgsConstructor
public class MessageFactory implements AbstractBaseEntityFactory {
    private int id;
    private LocalDateTime createdAt;
    private String content;
    private User sender;
    private User receiver;
    private LocalDateTime seenAt;
    @Override
    public BaseEntity createEntity() {
        return new Message(id, createdAt, content, sender, receiver, seenAt);
    }
}
