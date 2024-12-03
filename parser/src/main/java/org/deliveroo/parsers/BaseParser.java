package org.deliveroo.parsers;

import org.deliveroo.utlis.CronParserUtils;

public abstract class BaseParser {
    public final String name;
    protected final int low;
    protected final int high;

    public BaseParser(int low, int high, String name) {
        this.low = low;
        this.high = high;
        this.name = name;
    }

    public String parse(String input) {
        String result;
        if (input.contains(",")) {
            result = CronParserUtils.commaParser(input, low, high);
        } else if (input.contains("/")) {
            result = CronParserUtils.stepParser(input, low, high);
        } else if (input.contains("-")) {
            result = CronParserUtils.rangeParser(input, low, high);
        } else if (input.equals("*")) {
            result = CronParserUtils.universeParser(low, high);
        } else {
            result = input;
        }

        return String.format("%s %s", name, result);
    }
}