package com.verbovskiy.task5.reader;

import java.util.Scanner;

public class ConsoleReader {
    public String readText() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

         return text;
    }

    public int readNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        return number;
    }
}
