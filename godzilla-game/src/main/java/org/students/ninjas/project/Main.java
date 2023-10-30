package org.students.ninjas.project;

import org.students.ninjas.project.domain.Options;
import org.students.ninjas.project.domain.Result;
import org.students.ninjas.project.domain.Task;
import org.students.ninjas.project.domain.TaskRunner;
import org.students.ninjas.project.domain.TaskRunnerBuilder;
import org.students.ninjas.project.domain.enums.Command;

import java.util.Map;

import static org.students.ninjas.project.domain.enums.Command.COMPILE;
import static org.students.ninjas.project.domain.enums.Command.PACKAGE;
import static org.students.ninjas.project.domain.enums.Command.RUN;

public class Main {
    public static void main(String[] args) {

        Options compileOptions = new Options(COMPILE);
        compileOptions.setOptions("javac");
        compileOptions.setOptions("TestApp.java");
        compileOptions.setDir("godzilla-game/src/main/resources");

        Options runOptions = new Options(RUN);
        runOptions.setOptions("java");
        runOptions.setOptions("TestApp.java");
        runOptions.setDir("godzilla-game/src/main/resources");

        Options packageOptions = new Options(PACKAGE);
        packageOptions.setOptions("jar");
        packageOptions.setOptions("cfe");
        packageOptions.setOptions("TestApp.jar");
        packageOptions.setOptions("TestApp");
        packageOptions.setOptions("TestApp.class");
        packageOptions.setDir("godzilla-game/src/main/resources");

        TaskRunner appBuildTaskRunner = new TaskRunnerBuilder()
                .addTask(new Task(compileOptions))
                .addTask(new Task(runOptions))
                .addTask(new Task(packageOptions))
                .build();
        appBuildTaskRunner.start();

        for (Map.Entry<Map<Command, Options>, Result> entry : appBuildTaskRunner.getLog().entrySet()) {
            for (Map.Entry<Command, Options> entry1 : entry.getKey().entrySet()) {
                System.out.println(entry1.getKey() + " : " + entry1.getValue());

            }
            System.out.println(entry.getValue() + "\n");
        }
    }
}
