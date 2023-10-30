package org.students.ninjas.project.domain;

import lombok.Getter;
import org.students.ninjas.project.domain.enums.Command;

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

    public void setOptions(String command) {
        options.add(command);
    }

    public void setDir(String dir) {
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
