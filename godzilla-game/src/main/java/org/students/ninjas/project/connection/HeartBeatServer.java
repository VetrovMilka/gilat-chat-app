package org.students.ninjas.project.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HeartBeatServer {

    private static final Integer PORT = Integer.parseInt(ConfigurationProvider.getProperties().get("port").toString());

    public static void main(String[] args) {
        System.out.println("Server started. Listening on port " + PORT);
        try (ServerSocket server = new ServerSocket(PORT);
             Socket client = server.accept();
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
        ) {
            System.out.println("Client connected on port " + PORT);
            String input;
            while ((input = in.readLine()) != null) {
                System.out.println("Message Received: \"" + input + "\" from " + client.getInetAddress());
                out.println("Hi client!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Shutting down server!!");
        }
    }
}
