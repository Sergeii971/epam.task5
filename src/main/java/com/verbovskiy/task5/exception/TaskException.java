package com.verbovskiy.task5.exception;

public class TaskException extends Exception {
    public TaskException() {
        super();
    }

    public TaskException(String message) {
        super(message);
    }

    public TaskException(String message, Throwable throwable) {
        super(message,throwable);
    }

    public TaskException(Throwable throwable) {
        super(throwable);
    }
}
