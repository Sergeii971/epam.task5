package com.verbovskiy.task5.creator;

import com.verbovskiy.task5.exception.TaskException;
import com.verbovskiy.task5.reader.ConsoleReader;
import com.verbovskiy.task5.reader.FileReader;

public class TextCreator {
    public String readTextFromConsole() {
        ConsoleReader consoleReader = new ConsoleReader();
        String text = consoleReader.readText();

        return text;
    }

    public String readTextFromFile(String fileName) throws TaskException {
        FileReader fileReader = new FileReader();
        String text = fileReader.readText(fileName);

        return  text;
    }

    public int readNumberFromConsole() {
        ConsoleReader consoleReader = new ConsoleReader();
        int number = consoleReader.readNumber();

        return number;
    }
}
