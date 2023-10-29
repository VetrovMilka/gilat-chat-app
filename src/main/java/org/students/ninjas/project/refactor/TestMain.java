package org.students.ninjas.project.refactor;

import java.util.Map;

public class TestMain {
    public static void main(String[] args) {

        Options compileOptions = new Options();
        compileOptions.set("command", "javac");
        compileOptions.set("arg1", "TestApp.java");
        compileOptions.set("dir", "src/main/resources");

        Options runOptions = new Options();
        runOptions.set("command", "java");
        runOptions.set("arg1", "TestApp.java");
        runOptions.set("dir", "src/main/resources");

        Options packageOptions = new Options();
        packageOptions.set("command", "jar");
        packageOptions.set("arg1", "cfe");
        packageOptions.set("arg2", "TestApp.jar");
        packageOptions.set("arg3", "TestApp");
        packageOptions.set("arg4", "TestApp.class");
        packageOptions.set("dir", "src/main/resources");

        TaskRunner appBuildTaskRunner = new TaskRunnerBuilder()
                .addTask(new CompileTask(), compileOptions)
                .addTask(new RunTask(), runOptions)
                .addTask(new PackageTask(), packageOptions)
                .build();
        appBuildTaskRunner.start();

        for(Map.Entry<Map<Task, Options>, Result> entry : appBuildTaskRunner.getLog().entrySet()) {
            for(Map.Entry<Task, Options> entry1 : entry.getKey().entrySet()) {
                System.out.println(entry1.getKey() + " : " + entry1.getValue());

            }
            System.out.println(entry.getValue()+"\n");
        }
    }
}
