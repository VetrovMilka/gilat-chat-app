package org.students.ninjas.project.domain;

import java.util.ArrayList;
import java.util.List;

public class TaskRunnerBuilder {

    private final List<Task> tasks = new ArrayList<>();

    public TaskRunnerBuilder addTask(Task task) {
        tasks.add(task);
        return this;
    }

    public TaskRunner build() {
        return new TaskRunner(tasks);
    }
}
