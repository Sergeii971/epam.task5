package com.verbovskiy.task5.service.impl;

import com.verbovskiy.task5.exception.TaskException;
import com.verbovskiy.task5.service.ChangeText;
import com.verbovskiy.task5.validator.IndexValidator;

public class StringChangeTextImpl implements ChangeText {
    private final String FOUR_FIRST_WORD_CHARACTER = "(\\b\\p{L}{%d})\\p{L}";
    private final String WORD_WITHOUT_LAST_CHARACTER = "$1";
    private final String CHARACTER_EXCEPT_LETTER = "[\\p{Punct}\\d]";


    @Override
    public String replaceCharacter(String text, int characterIndexToReplace,
                                   String replacingCharacter) throws TaskException {
        IndexValidator indexValidator = new IndexValidator();

        if ((text == null) || (text.isEmpty()) || (!indexValidator.validateSymbolIndexInWord(characterIndexToReplace))
                || (replacingCharacter == null) || (replacingCharacter.length() != 1)) {
            throw new TaskException("incorrect data");
        }
        String editedText = text.replaceAll(String.format(FOUR_FIRST_WORD_CHARACTER,
                characterIndexToReplace), WORD_WITHOUT_LAST_CHARACTER.concat( replacingCharacter));

        return editedText;
    }

    @Override
    public String correctMistake(String text,String mistake, String mistakeReplacing) throws TaskException {
        if ((text == null) || (text.isEmpty()) || (mistake == null) || (mistakeReplacing == null)
                || (mistake.length() != mistakeReplacing.length())) {
            throw new TaskException("incorrect data");
        }

        String editedText = text.replaceAll(mistake,mistakeReplacing);

        return editedText;
    }

    @Override
    public String replaceSubstringCertainLength(String text, String substring, int wordSize) throws TaskException {
        if ((text == null) || (text.isEmpty()) || (substring == null)
                || (wordSize <= 0)) {
            throw new TaskException("incorrect data");
        }
        String[] words = text.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i].replaceAll(CHARACTER_EXCEPT_LETTER,"");

            if (word.length() == wordSize) {
                words[i] = substring;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        for(String word : words) {
            stringBuilder.append(word);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
