package com.verbovskiy.task5.service.impl;

import com.verbovskiy.task5.exception.TaskException;
import com.verbovskiy.task5.service.ChangeText;
import com.verbovskiy.task5.service.conversion.TextConversionService;

import java.util.List;

public class ArrayChangeTextImpl implements ChangeText {

    @Override
    public String replaceCharacter(String text,int characterIndexToReplace,
                                   String replacingCharacter) throws TaskException {
        if ((text == null) || (text.isEmpty()) || (characterIndexToReplace < 0)
                || (replacingCharacter == null) || (replacingCharacter.length() != 1)) {
            throw new TaskException("incorrect data");
        }
        char[] textCharFormat = text.toCharArray();
        char replacingCharacterCharFormat = replacingCharacter.charAt(0);
        int wordCharacterNumber = 0;

        for (int i = 0; i < textCharFormat.length; i++) {
            if (Character.isLetter(textCharFormat[i])) {
                if (wordCharacterNumber == characterIndexToReplace) {
                    textCharFormat[i] = replacingCharacterCharFormat;
                }
                wordCharacterNumber++;
            } else {
                 wordCharacterNumber = 0;
            }
        }
        return String.valueOf(textCharFormat);
    }

    @Override
    public String correctMistake(String text, String mistake,
                                      String mistakeReplacing) throws TaskException {
        if ((text == null) || (text.isEmpty()) || (mistake == null) || (mistakeReplacing == null)
                || (mistake.length() != mistakeReplacing.length())) {
            throw new TaskException("incorrect data");
        }
        char[] textCharFormat = text.toCharArray();
        char[] mistakeCharFormat = mistake.toCharArray();
        char[] mistakeReplacingCharFormat = mistakeReplacing.toCharArray();

        for (int i = 0; i < textCharFormat.length; i++) {
            boolean isMistake = true;

            if (textCharFormat[i] == mistakeCharFormat[0]) {
                for (int j = 1; j < mistakeCharFormat.length; j++) {
                    if (textCharFormat[i + j] != mistakeCharFormat[j]) {
                        isMistake = false;
                        break;
                    }
                }
                if (isMistake) {
                    for (int j = 0; j < mistakeCharFormat.length; j++) {
                        textCharFormat[i + j] = mistakeReplacingCharFormat[j];
                    }
                }
            }
        }
        return String.valueOf(textCharFormat);
    }

    @Override
    public String replaceSubstringCertainLength(String text, String substring, int wordSize) throws TaskException {
        if ((text == null) || (text.isEmpty()) || (substring == null)
                || (wordSize <= 0)) {
            throw new TaskException("incorrect data");
        }
        TextConversionService textConversionService = new TextConversionService();
        List<String> words = textConversionService.splitTextOnWord(text);

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() == wordSize) {
                words.set(i, substring);
            }
        }
        return textConversionService.restoreText(words);
    }
}
