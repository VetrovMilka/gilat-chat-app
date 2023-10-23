package org.students.ninjas.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Message extends BaseEntity{
    private String content;
    private User sender;
    private User receiver;
    private LocalDateTime seenAt;

    public Message(LocalDateTime createdAt, String content, User sender, User receiver, LocalDateTime seenAt) {
        super(createdAt);
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
