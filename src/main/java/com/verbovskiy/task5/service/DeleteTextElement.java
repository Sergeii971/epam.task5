package com.verbovskiy.task5.service;

import com.verbovskiy.task5.exception.TaskException;

public interface DeleteTextElement {
    String deleteNotLetterCharacters(String text) throws TaskException;

    String deleteWordOfCertainLengthStartConsonant(String text, int wordSize) throws TaskException;
}
