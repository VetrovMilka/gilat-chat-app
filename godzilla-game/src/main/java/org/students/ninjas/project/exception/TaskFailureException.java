package org.students.ninjas.project.exception;

public class TaskFailureException extends RuntimeException {
    public TaskFailureException(int exitCode, String output) {
        super("Task failed with exit code " + exitCode + " and output: " + output);
    }
}
