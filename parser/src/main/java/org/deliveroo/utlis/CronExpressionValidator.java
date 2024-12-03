package org.deliveroo.utlis;

import org.deliveroo.exceptions.InvalidCronExpressionException;

public class CronExpressionValidator {

    public static void validateExpression(String expression) {
        String[] fields = expression.split("\\s+");

        if (fields.length != 6) {
            throw new InvalidCronExpressionException("Invalid cron expression length");
        }

        validateField(fields[0], CronConstants.MIN_MINUTE, CronConstants.MAX_MINUTE, "Minute");
        validateField(fields[1], CronConstants.MIN_HOUR, CronConstants.MAX_HOUR, "Hour");
        validateField(fields[2], CronConstants.MIN_DAY, CronConstants.MAX_DAY, "Day of Month");
        validateField(fields[3], CronConstants.MIN_MONTH, CronConstants.MAX_MONTH, "Month");
        validateField(fields[4], CronConstants.MIN_DOW, CronConstants.MAX_DOW, "Day of Week");

        if (fields[5].isEmpty()) {
            throw new InvalidCronExpressionException("Command field cannot be empty.");
        }
    }

    private static void validateField(String field, int min, int max, String fieldName) {
        if (CronConstants.WILDCARD.matcher(field).matches()) {
            return;
        }

        if (CronConstants.NUMBER.matcher(field).matches()) {
            validateRange(Integer.parseInt(field), min, max, fieldName);
        } else if (CronConstants.RANGE.matcher(field).matches()) {
            String[] parts = field.split("-");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            if (start > end) {
                throw new IllegalArgumentException(fieldName + " range start cannot be greater than end: " + field);
            }
            validateRange(start, min, max, fieldName);
            validateRange(end, min, max, fieldName);
        } else if (CronConstants.STEP.matcher(field).matches()) {
            String[] parts = field.split("/");
            if (!parts[0].equals("*") && !CronConstants.RANGE.matcher(parts[0]).matches()) {
                throw new IllegalArgumentException("Invalid step value in " + fieldName + ": " + field);
            }
            int step = Integer.parseInt(parts[1]);
            if (step <= 0) {
                throw new IllegalArgumentException(fieldName + " step value must be positive: " + field);
            }
        } else if (CronConstants.LIST.matcher(field).matches()) {
            String[] parts = field.split(",");
            for (String part : parts) {
                validateField(part, min, max, fieldName);
            }
        } else {
            throw new IllegalArgumentException("Invalid " + fieldName + " value: " + field);
        }
    }

    private static void validateRange(int value, int min, int max, String fieldName) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(
                    String.format("%s value out of range (%d-%d): %d", fieldName, min, max, value)
            );
        }
    }
}

