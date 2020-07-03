package com.verbovskiy.task5.service.impl;

import com.verbovskiy.task5.exception.TaskException;
import com.verbovskiy.task5.service.DeleteTextElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDeleteTextElementImpl implements DeleteTextElement {
    private final String VOWELS = "aeiouyуеыаоэяию";
    private final String SYMBOL_EXCEPT_LETTER = "[\\p{Punct}\\d]";
    private final String WORD_CERTAIN_LENGTH = "\\b(\\p{L})\\p{L}{%d}\\b";

    @Override
    public String deleteNotLetterCharacters(String text) throws TaskException {
        if ((text == null) || (text.isEmpty())) {
            throw  new TaskException("incorrect data");
        }
        Pattern pattern = Pattern.compile(SYMBOL_EXCEPT_LETTER);
        Matcher matcher = pattern.matcher(text);
        String editedText = matcher.replaceAll(" ");

        return editedText;
    }

    @Override
    public String deleteWordOfCertainLengthStartConsonant(String text, int wordSize) throws TaskException {
        if ((text == null) || (text.isEmpty()) || (wordSize <= 0)) {
            throw new TaskException("incorrect data");
        }
        StringBuffer stringBuffer = new StringBuffer();
        Pattern pattern = Pattern.compile(String.format(WORD_CERTAIN_LENGTH, wordSize - 1));
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            if (isFirstWordSymbolConsonant(matcher.group(1))) {
                matcher.appendReplacement(stringBuffer, "");
            }
        }
        matcher.appendTail(stringBuffer);

        return stringBuffer.toString();
    }

    private boolean isFirstWordSymbolConsonant(String word) {
        char firstSymbol = Character.toLowerCase(word.charAt(0));

        return (VOWELS.indexOf(firstSymbol) == -1);
    }
}
