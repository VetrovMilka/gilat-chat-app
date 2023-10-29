package org.students.ninjas.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NetworkDiscovery {

    public static void main(String[] args) {
        try {
            String[] command = {"nmap", "-p-", "10.128.128.0/24"};

            ProcessBuilder processBuilder = new ProcessBuilder(command);

            Process process = processBuilder.start();

            processBuilder.redirectErrorStream(true);

            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();

            System.out.println("Command exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
