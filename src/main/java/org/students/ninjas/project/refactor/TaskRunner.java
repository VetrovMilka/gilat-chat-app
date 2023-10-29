package org.students.ninjas.project.refactor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskRunner {

    private final LinkedHashMap<Task, Options> tasks;
    private final Map<Map<Task, Options>, Result> log = new HashMap<>();

    public TaskRunner(LinkedHashMap<Task, Options> tasks) {
        this.tasks = tasks;
    }

    void start() {
        for (Map.Entry<Task, Options> entry : tasks.entrySet()) {
            Task task = entry.getKey();
            Options options = entry.getValue();
            Result result = task.execute(options);
            log.put(Map.of(task, options), result);
            if (result.getExitCode() != 0) {
                throw new TaskFailureException(result.getExitCode(), result.getOutput());
            }
        }
    }

    Map<Map<Task, Options>, Result> getLog() {
        return log;
    }
}
