package com.verbovskiy.task5.reader;

import com.verbovskiy.task5.exception.TaskException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataFileReader {
    public String readText(String fileName) throws TaskException {
        Path path = Paths.get(fileName);
        if (Files.notExists(path)) {
           throw new TaskException("file not exists");
        }
        try {
            List<String> textWithoutHyphens = Files.readAllLines(path);
            String text = String.join("\n", textWithoutHyphens);

            return text;
        } catch (IOException e) {
            throw new TaskException("incorrect file", e);
        }
    }
}
