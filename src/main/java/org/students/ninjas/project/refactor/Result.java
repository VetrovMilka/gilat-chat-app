package org.students.ninjas.project.refactor;

public class Result {
    @Override
    public String toString() {
        return "Result{" +
                "exitCode=" + exitCode +
                ", output='" + output + '\'' +
                '}';
    }

    private int exitCode;
    private String output;

    int getExitCode() {
        return exitCode;
    }

    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    }

    String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
