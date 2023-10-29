package org.students.ninjas.firstTask.entity.factory;

import lombok.AllArgsConstructor;
import org.students.ninjas.firstTask.entity.BaseEntity;
import org.students.ninjas.firstTask.entity.Message;
import org.students.ninjas.firstTask.entity.User;

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
