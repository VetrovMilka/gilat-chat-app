package org.students.ninjas.testProcessBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppBuilder {

    private static final String JAVA_FILE_PATH = "TestApp.java";
    private static final String CLASS_FILE_ROOT = "src/main/resources";
    private static final String CLASS_FILE_PATH = "TestApp";
    public static void main(String[] args) throws IOException, InterruptedException {

        ProcessBuilder compile = new ProcessBuilder("javac", JAVA_FILE_PATH);
        compile.directory(new File(CLASS_FILE_ROOT));
        compile.start();

        ProcessBuilder run = new ProcessBuilder("java", CLASS_FILE_PATH);
        run.directory(new File(CLASS_FILE_ROOT));
        Process runJava = run.start();

        System.out.println("Expected result: Hello world");
        BufferedReader reader = new BufferedReader(new InputStreamReader(runJava.getInputStream()));
        System.out.println(reader.readLine());

        ProcessBuilder jar = new ProcessBuilder("jar", "cfe", "TestApp.jar", "TestApp" , CLASS_FILE_PATH + ".class");
        jar.directory(new File(CLASS_FILE_ROOT));

        int exitCode = jar.start().waitFor();

        if (exitCode == 0) {
            System.out.println("JAR file created successfully.");
        } else {
            System.err.println("JAR file creation failed.");
        }
    }
}
