package org.students.ninjas.entity.factory;

import lombok.AllArgsConstructor;
import org.students.ninjas.entity.BaseEntity;
import org.students.ninjas.entity.Message;
import org.students.ninjas.entity.User;

import java.time.LocalDateTime;

/**
 * The type Message factory creating a Message entity
 */
@AllArgsConstructor
public class MessageFactory implements AbstractBaseEntityFactory {
    private String content;
    private User sender;
    private User receiver;
    private LocalDateTime seenAt;

    @Override
    public BaseEntity createEntity() {
        return new Message(content, sender, receiver, seenAt);
    }
}
