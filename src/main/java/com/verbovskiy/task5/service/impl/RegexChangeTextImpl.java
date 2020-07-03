package com.verbovskiy.task5.service.impl;

import com.verbovskiy.task5.exception.TaskException;
import com.verbovskiy.task5.service.ChangeText;
import com.verbovskiy.task5.validator.IndexValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChangeTextImpl implements ChangeText {
    private final String FOUR_FIRST_WORD_CHARACTER = "(\\b\\p{L}{%d})\\p{L}";
    private final String WORD_WHERE_LAST_CHARACTER_IS_CHANGED = "$1%s";
    private static final String WORD_CERTAIN_LENGTH = "\\b\\p{L}{%d}\\b";

    @Override
    public String replaceCharacter(String text, int characterIndexToReplace,
                                   String replacingCharacter) throws TaskException {
        IndexValidator indexValidator = new IndexValidator();

        if ((text == null) || (text.isEmpty()) || (!indexValidator.validateSymbolIndexInWord(characterIndexToReplace))
                || (replacingCharacter == null) || (replacingCharacter.length() != 1)) {
            throw new TaskException("incorrect data");
        }
        String editedText;
        Pattern pattern = Pattern.compile(String.format(FOUR_FIRST_WORD_CHARACTER, characterIndexToReplace));
        Matcher matcher = pattern.matcher(text);
        editedText = matcher.replaceAll(String.format(WORD_WHERE_LAST_CHARACTER_IS_CHANGED, replacingCharacter));

        return editedText;
    }

    @Override
    public String correctMistake(String text, String mistake, String mistakeReplacing) throws TaskException {
        if ((text == null) || (text.isEmpty()) || (mistake == null) || (mistakeReplacing == null)
                || (mistake.length() != mistakeReplacing.length())) {
            throw new TaskException("incorrect data");
        }
        Pattern pattern = Pattern.compile(mistake);
        Matcher matcher = pattern.matcher(text);
        String editedText = matcher.replaceAll(mistakeReplacing);

        return editedText;
    }

    @Override
    public String replaceSubstringCertainLength(String text, String substring, int wordSize) throws TaskException {
        if ((text == null) || (text.isEmpty()) || (substring == null)
                || (wordSize <= 0)) {
            throw new TaskException("incorrect data");
        }
        Pattern pattern = Pattern.compile(String.format(WORD_CERTAIN_LENGTH, wordSize));
        Matcher matcher = pattern.matcher(text);
        String editedText = matcher.replaceAll(substring);

        return editedText;
    }
}
