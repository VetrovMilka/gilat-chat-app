package org.students.ninjas.project.domain;

import lombok.Getter;


@Getter
public class Result {

    private int exitCode;
    private String output;

    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "Result{" +
                "exitCode=" + exitCode +
                ", output='" + output + '\'' +
                '}';
    }
}
