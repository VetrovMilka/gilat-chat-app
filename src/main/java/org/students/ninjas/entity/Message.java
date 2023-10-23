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

    public Message(int id, LocalDateTime createdAt, String content, User sender, User receiver, LocalDateTime seenAt) {
        super(id, createdAt);
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.seenAt = seenAt;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", sender username=" + ((sender == null) ? null : sender.getId()) +
                ", receiver username=" + ((receiver == null) ? null : receiver.getId()) +
                ", seenAt=" + seenAt +
                '}';
    }
}
