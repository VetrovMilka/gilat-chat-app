package org.students.ninjas.project.refactor;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Options {

    private final List<String> options = new ArrayList<>();
    private String dir = System.getProperty("user.dir");

    void setOptions(String command) {
        options.add(command);
    }

    void setDir(String dir) {
        this.dir = dir;
    }
}
