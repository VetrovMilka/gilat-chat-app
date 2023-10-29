package org.students.ninjas.project.refactor;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Options {

    private final Command command;

    private final List<String> options = new ArrayList<>();

    private String dir = System.getProperty("user.dir");

    public Options(Command command) {
        this.command = command;
    }

    void setOptions(String command) {
        options.add(command);
    }

    void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "Options{" +
                options +
                ", dir='" + dir + '\'' +
                '}';
    }
}
