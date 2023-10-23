package org.students.ninjas.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * The type Message extended from BaseEntity
 */
@Getter
@Setter
public class Message extends BaseEntity {
    private String content;
    private User sender;
    private User receiver;
    private LocalDateTime seenAt;

    /**
     * Instantiates a new Message.
     *
     * @param content  the content
     * @param sender   the sender
     * @param receiver the receiver
     * @param seenAt   the seen at
     */
    public Message(String content, User sender, User receiver, LocalDateTime seenAt) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.seenAt = seenAt;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", sender username=" + ((sender == null) ? null : sender.getUsername()) +
                ", receiver username=" + ((receiver == null) ? null : receiver.getUsername()) +
                ", seenAt=" + seenAt +
                '}';
    }
}
