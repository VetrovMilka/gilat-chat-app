package org.students.ninjas.project.refactor;

import java.util.ArrayList;
import java.util.List;

public class TaskRunnerBuilder {

    private final List<Task> tasks = new ArrayList<>();

    TaskRunnerBuilder addTask(Task task) {
        tasks.add(task);
        return this;
    }

    TaskRunner build() {
        return new TaskRunner(tasks);
    }
}
