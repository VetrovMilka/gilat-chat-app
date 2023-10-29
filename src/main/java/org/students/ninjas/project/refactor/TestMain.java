package org.students.ninjas.project.refactor;

import java.util.Map;

public class TestMain {
    public static void main(String[] args) {

        Options compileOptions = new Options();
        compileOptions.setOptions("javac");
        compileOptions.setOptions("TestApp.java");
        compileOptions.setDir("src/main/resources");

        Options runOptions = new Options();
        runOptions.setOptions("java");
        runOptions.setOptions("TestApp.java");
        runOptions.setDir("src/main/resources");

        Options packageOptions = new Options();
        packageOptions.setOptions("jar");
        packageOptions.setOptions("cfe");
        packageOptions.setOptions("TestApp.jar");
        packageOptions.setOptions("TestApp");
        packageOptions.setOptions("TestApp.class");
        packageOptions.setDir("src/main/resources");

        TaskRunner appBuildTaskRunner = new TaskRunnerBuilder()
                .addTask(new Task(compileOptions))
                .addTask(new Task(runOptions))
                .addTask(new Task(packageOptions))
                .build();
        appBuildTaskRunner.start();

        for (Map.Entry<Map<Task, Options>, Result> entry : appBuildTaskRunner.getLog().entrySet()) {
            for (Map.Entry<Task, Options> entry1 : entry.getKey().entrySet()) {
                System.out.println(entry1.getKey() + " : " + entry1.getValue());

            }
            System.out.println(entry.getValue() + "\n");
        }
    }
}
