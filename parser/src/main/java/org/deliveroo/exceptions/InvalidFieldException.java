package org.deliveroo.exceptions;

public class InvalidFieldException extends CronParseException {
    public InvalidFieldException(String fieldName) {
        super("Invalid field name: " + fieldName);
    }
}
