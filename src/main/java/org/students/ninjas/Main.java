package org.students.ninjas;

import org.students.ninjas.entity.Message;
import org.students.ninjas.entity.User;
import org.students.ninjas.entity.factory.BaseEntityFactory;
import org.students.ninjas.entity.factory.MessageFactory;
import org.students.ninjas.entity.factory.UserFactory;
import org.students.ninjas.repository.MessageRepository;
import org.students.ninjas.repository.MessageRepositoryImpl;
import org.students.ninjas.repository.UserRepository;
import org.students.ninjas.repository.UserRepositoryImpl;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        MessageRepository messageRepository = new MessageRepositoryImpl();

        User user1 = (User) BaseEntityFactory.getBaseEntity(new UserFactory(1,
                LocalDateTime.now(),
                "test",
                "test2",
                "email",
                "username",
                "3290840923",
                LocalDateTime.now(),
                true));

        User user2 = (User) BaseEntityFactory.getBaseEntity(new UserFactory(2,
                LocalDateTime.now(),
                "test3",
                "test4",
                "email2",
                "username2",
                "3290840924",
                LocalDateTime.now(),
                true));

        Message message = (Message) BaseEntityFactory.getBaseEntity(new MessageFactory(1,
                LocalDateTime.now(),
                "asdasd",
                user1,
                user2,
                LocalDateTime.now()));

        System.out.println("\nAdded user: " + userRepository.addUser(user1));
        System.out.println("Added user: " + userRepository.addUser(user2));
        System.out.println("Added message: " + messageRepository.addMessage(message));
        System.out.println("\nGet user with id 1: " + userRepository.getUserById(1));
        System.out.println("Delete user with id 1: " + userRepository.deleteUserById(1));
        System.out.println("Get deleted user with id 1: " + userRepository.getUserById(1));
        System.out.println("\nDelete message with id 1: " + messageRepository.deleteMessageById(1));
        System.out.println("Get deleted message with id 1: " + messageRepository.getMessageById(1));
    }
}