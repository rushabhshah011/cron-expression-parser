package org.deliveroo.cronengine;

import org.deliveroo.exceptions.InvalidCronExpressionException;
import org.deliveroo.parsers.BaseParser;
import org.deliveroo.utlis.CronExpressionValidator;

import java.util.List;
import java.util.StringJoiner;

import static org.deliveroo.utlis.CronConstants.*;

public class CronExpressionParser {

    private static final List<String> FIELD_NAMES = List.of(
            MINUTE,
            HOUR,
            DAY_OF_MONTH,
            MONTH,
            DAY_OF_WEEK,
            COMMAND
    );

    public String parse(String input) {
        CronExpressionValidator.validateExpression(input);

        String[] params = input.split("\\s+");
        if (params.length != FIELD_NAMES.size()) {
            throw new InvalidCronExpressionException(
                    "Invalid cron expression length. Expected " + FIELD_NAMES.size() + " fields, but got " + params.length + "."
            );
        }

        StringJoiner output = new StringJoiner("\n");
        for (int i = 0; i < FIELD_NAMES.size(); i++) {
            BaseParser parser = CronFieldFactory.createField(FIELD_NAMES.get(i));
            output.add(parser.parse(params[i]));
        }

        return output.toString();
    }
}