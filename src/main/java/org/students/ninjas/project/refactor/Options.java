package org.students.ninjas.project.refactor;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;
@Builder
public class Options {
    private final Map<String, String> options = new HashMap<>();

    void set(String key , Object value) {
        options.put(key, value.toString());
    }

    String get(String key) {
        return options.get(key);
    }

    @Override
    public String toString() {
        return "Options{" +
                "options=" + options +
                '}';
    }
}
