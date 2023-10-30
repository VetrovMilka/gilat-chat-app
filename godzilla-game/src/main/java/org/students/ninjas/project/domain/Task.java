package org.students.ninjas.project.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


@Getter
@RequiredArgsConstructor
public class Task {

    private final Options options;

    public Result execute() throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(String.valueOf(options.getCommand()));
        builder.command(options.getOptions());
        builder.directory(new File(options.getDir()));
        Process process = builder.start();
        process.waitFor();
        Result result = new Result();
        result.setExitCode(process.exitValue());
        if (result.getExitCode() == 0)
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
        return "Task";
    }
}
