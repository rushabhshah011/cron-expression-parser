package org.deliveroo.parsers;


import static org.deliveroo.utlis.CronConstants.COMMAND;

public class CommandParser extends BaseParser {
    public CommandParser() {
        super(-1, -1, COMMAND);
    }

    @Override
    public String parse(String input) {
        return String.format("%-14s%s", name, input);
    }
}

