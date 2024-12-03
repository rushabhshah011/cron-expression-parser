package org.deliveroo.exceptions;

public class InsufficientArgumentsException extends RuntimeException {
    public InsufficientArgumentsException(String message) {
        super(message);
    }
}
