package com.verbovskiy.task5.validator;

public class IndexValidator {
    private final int SIZE_OF_LONGEST_WORD = 189819;

    public boolean validateSymbolIndexInWord(int index) {
        return ((index >= 0) && (index <= SIZE_OF_LONGEST_WORD));
    }
}
