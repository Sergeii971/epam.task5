package com.verbovskiy.task5.service.impl;

import com.verbovskiy.task5.exception.TaskException;
import com.verbovskiy.task5.service.DeleteTextElement;

public class StringDeleteTextElementImpl implements DeleteTextElement {
    private final String VOWELS = "aeiouаоеёюиуыэя";
    private final String CHARACTER_EXCEPT_LETTER = "[\\p{Punct}\\d]";

    @Override
    public String deleteNotLetterCharacters(String text) throws TaskException {
        if ((text == null) || (text.isEmpty())) {
            throw  new TaskException("incorrect data");
        }
        String replacingText = text.replaceAll(CHARACTER_EXCEPT_LETTER," ");

        return  replacingText;
    }

    @Override
    public String deleteWordOfCertainLengthStartConsonant(String text, int wordSize) throws TaskException {
        if ((text == null) || (text.isEmpty()) || (wordSize <= 0)) {
            throw new TaskException("incorrect data");
        }
        String[] words = text.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String wordWithoutPunctuation = deleteNotLetterCharacters(words[i]);
            wordWithoutPunctuation = wordWithoutPunctuation.replace(" ", "");

            if ((wordWithoutPunctuation.length() == wordSize)
                    && (isFirstWordSymbolConsonant(wordWithoutPunctuation))) {
                if ((words[i].length() != wordWithoutPunctuation.length())) {
                    char lastCharacter = words[i].charAt(words[i].length() - 1);
                    stringBuilder.append(lastCharacter);stringBuilder.append(" ");
                }
            } else {
                stringBuilder.append(words[i]);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    private boolean isFirstWordSymbolConsonant(String word) {
        char firstSymbol = Character.toLowerCase(word.charAt(0));

        return (VOWELS.indexOf(firstSymbol) == -1);
    }
}
