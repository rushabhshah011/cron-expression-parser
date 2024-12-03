package org.deliveroo.utlis;

import java.util.StringJoiner;

public class CronParserUtils {

    public static String commaParser(String input, int low, int high) {
        StringJoiner result = new StringJoiner(" ");
        String[] parts = input.split(",");

        for (String part : parts) {
            if (part.contains("-")) {
                result.add(rangeParser(part, low, high));
            } else {
                result.add(part);
            }
        }

        return result.toString();
    }

    public static String stepParser(String input, int low, int high) {
        StringJoiner result = new StringJoiner(" ");
        String[] stepParts = input.split("/");
        String rangePart = stepParts[0].equals("*") ? low + "-" + high : stepParts[0];

        String[] range = rangePart.split("-");
        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);
        int step = Integer.parseInt(stepParts[1]);

        for (int i = start; i <= end; i += step) {
            result.add(String.valueOf(i));
        }

        return result.toString();
    }

    public static String rangeParser(String input, int low, int high) {
        StringJoiner result = new StringJoiner(" ");
        String[] rangeParts = input.split("-");
        int start = Integer.parseInt(rangeParts[0]);
        int end = Integer.parseInt(rangeParts[1]);

        for (int i = start; i <= end; i++) {
            result.add(String.valueOf(i));
        }

        return result.toString();
    }

    public static String universeParser(int low, int high) {
        StringJoiner result = new StringJoiner(" ");
        for (int i = low; i <= high; i++) {
            result.add(String.valueOf(i));
        }
        return result.toString();
    }
}
