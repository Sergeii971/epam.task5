package com.verbovskiy.task5.service.conversion;

import com.verbovskiy.task5.exception.TaskException;

import java.util.ArrayList;
import java.util.List;

public class TextConversionService {
    public String restoreText(List<String> words) throws TaskException {
        if (words == null || words.size() == 0) {
            throw new TaskException("incorrect data");
        }
        StringBuilder text = new StringBuilder();

        for (String word : words) {
            text.append(word);
        }
        return text.toString();
    }

    public List<String> splitTextOnWord(String text) throws TaskException {
        if (text == null || text.length() == 0) {
            throw new TaskException("incorrect data");
        }
        List<String> words = new ArrayList<>();
        char[] textCharFormat = text.toCharArray();
        StringBuilder word =new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(textCharFormat[i])) {
                word.append(textCharFormat[i]);
                if (text.length() - 1 == i) {
                    words.add(word.toString());
                    break;
                }
            } else {
                words.add(word.toString());
                if (textCharFormat[i] != ' ') {
                    words.add(String.valueOf(textCharFormat[i]));
                }
                words.add(" ");
                word = new StringBuilder();
            }
        }
        return words;
    }
}
