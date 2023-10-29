package org.students.ninjas.project.refactor;

import lombok.Getter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class TaskRunner {

    private final List<Task> tasks;
    private final Map<Map<Task, Options>, Result> log = new HashMap<>();

    public TaskRunner(List<Task> tasks) {
        this.tasks = tasks;
    }

    void start() {
        for (Task task : tasks) {
            Options options = task.getOptions();
            Result result;
            try {
                result = task.execute();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            log.put(Map.of(task, options), result);

            if (result.getExitCode() != 0) {
                throw new TaskFailureException(result.getExitCode(), result.getOutput());
            }
        }
    }
}
