package org.students.ninjas.project.refactor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskRunnerBuilder {

    private final LinkedHashMap<Task, Options> tasks = new LinkedHashMap<>();

    TaskRunnerBuilder addTask(Task task, Options options) {
        tasks.put(task, options);
        return this;
    }

    TaskRunner build() {
        return new TaskRunner(tasks);
    }
}
