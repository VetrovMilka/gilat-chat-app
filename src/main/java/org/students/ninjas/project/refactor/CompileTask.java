package org.students.ninjas.project.refactor;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class CompileTask implements Task {

    @SneakyThrows
    @Override
    public Result execute(Options options) {
        ProcessBuilder builder = new ProcessBuilder(options.get("command"), options.get("arg1"));
        builder.directory(new File(options.get("dir")));
        Process process = builder.start();
        process.waitFor();
        Result result = new Result();
        result.setExitCode(process.exitValue());
        if(result.getExitCode() == 0)
            result.setOutput(new BufferedReader(
                    new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n")));
        else {
            result.setOutput(new BufferedReader(
                    new InputStreamReader(process.getErrorStream(), StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n")));
        }
            return result;
    }

    @Override
    public String toString() {
        return "CompileTask";
    }
}
