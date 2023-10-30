package org.students.ninjas.project.domain;

import lombok.Getter;
import org.students.ninjas.project.domain.enums.Command;
import org.students.ninjas.project.exception.TaskFailureException;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
public class TaskRunner {

    private final List<Task> tasks;
    private final Map<Map<Command, Options>, Result> log = new LinkedHashMap<>();

    public TaskRunner(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void start() {
        for (Task task : tasks) {
            Options options = task.getOptions();
            Result result;
            try {
                result = task.execute();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            log.put(Map.of(options.getCommand(), options), result);

            if (result.getExitCode() != 0) {
                throw new TaskFailureException(result.getExitCode(), result.getOutput());
            }
        }
    }

}
