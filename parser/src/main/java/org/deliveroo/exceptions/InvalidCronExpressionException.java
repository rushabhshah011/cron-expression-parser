package org.deliveroo.exceptions;

public class InvalidCronExpressionException extends RuntimeException {

    public InvalidCronExpressionException(String message) {
        super(message);
    }
}