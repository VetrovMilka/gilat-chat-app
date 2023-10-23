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

        User user1 = (User) BaseEntityFactory.getBaseEntity(new UserFactory(
                "Miroslav",
                "Vetrov",
                "miroslav.vetrov2003@gmail.com",
                "v.vetrov.v",
                "+37369000000",
                LocalDateTime.now(),
                true));

        User user2 = (User) BaseEntityFactory.getBaseEntity(new UserFactory(
                "Semion",
                "Dubrovski",
                "siemion@gmail.com",
                "semion.d",
                "+37379000000",
                LocalDateTime.now(),
                true));

        Message message = (Message) BaseEntityFactory.getBaseEntity(new MessageFactory(
                "Send me some money",
                user1,
                user2,
                LocalDateTime.now()));

        System.out.println("\nAdded user: " + userRepository.addUser(user1));
        System.out.println("Added user: " + userRepository.addUser(user2));
        System.out.println("Added message: " + messageRepository.addMessage(message));
        System.out.println("\nGet user: " + userRepository.getUserById(1));
        System.out.println("Delete user: " + userRepository.deleteUserById(1));
        System.out.println("Get deleted user: " + userRepository.getUserById(1));
        System.out.println("\nDelete message: " + messageRepository.deleteMessageById(1));
        System.out.println("Get deleted message: " + messageRepository.getMessageById(1));
    }
}