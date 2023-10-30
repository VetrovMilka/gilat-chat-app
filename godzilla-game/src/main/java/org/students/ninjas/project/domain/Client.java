package org.students.ninjas.project.domain;

import org.students.ninjas.project.connection.ConfigurationProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private static final String HOST = ConfigurationProvider.getProperties().get("host").toString();
    private static final Integer PORT = Integer.parseInt(ConfigurationProvider.getProperties().get("port").toString());

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String clientMessage;
            while (!(clientMessage = stdIn.readLine()).equals("exit")) {
                out.println(clientMessage);
                System.out.println("Message Received: " + in.readLine());
            }
            System.out.println("Disconnected from host: " + HOST);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + HOST);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + HOST);
            System.exit(1);
        }
    }
}
