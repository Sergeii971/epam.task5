package com.verbovskiy.task5.service;

import com.verbovskiy.task5.exception.TaskException;

public interface ChangeText {
    String replaceCharacter(String text, int characterIndexToReplace,
                            String replacingCharacter) throws TaskException;

    String correctMistake(String text,String mistake, String mistakeReplacing) throws TaskException;

    String replaceSubstringCertainLength(String text, String substring, int wordSize) throws TaskException;
}
