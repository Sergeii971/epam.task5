package com.verbovskiy.task5.service.impl;

import com.verbovskiy.task5.exception.TaskException;
import com.verbovskiy.task5.service.DeleteTextElement;
import com.verbovskiy.task5.service.conversion.TextConversionService;

import java.util.List;

public class ArrayDeleteTextElementImpl implements DeleteTextElement {
    private final String VOWELS = "aeiouаоеёюиуыэя";

    @Override
    public String deleteNotLetterCharacters(String text) throws TaskException {
        if ((text == null) || (text.isEmpty())) {
            throw new TaskException("incorrect data");
        }
        char[] textCharFormat = text.toCharArray();

        for (int i = 0; i < textCharFormat.length; i++) {
            if ((!Character.isLetter(textCharFormat[i])) && (textCharFormat[i] != '\n')) {
                textCharFormat[i] = ' ';
            }
        }
        return String.valueOf(textCharFormat);
    }

    @Override
    public String deleteWordOfCertainLengthStartConsonant(String text, int wordSize) throws TaskException {
        if ((text == null) || (text.isEmpty()) || (wordSize <= 0)) {
            throw new TaskException("incorrect data");
        }
        TextConversionService textConversionService = new TextConversionService();
        List<String> words = textConversionService.splitTextOnWord(text);

        for (int i = 0; i < words.size(); i++) {
            if ((words.get(i).length() == wordSize) && (isFirstWordSymbolConsonant(words.get(i)))) {
                words.remove(i);
            }
        }
        return textConversionService.restoreText(words);
    }

    private boolean isFirstWordSymbolConsonant(String word) {
        char firstSymbol = Character.toLowerCase(word.charAt(0));

        return (VOWELS.indexOf(firstSymbol) == -1);
    }

}
