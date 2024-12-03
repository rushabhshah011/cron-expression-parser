package org.deliveroo;

import org.deliveroo.cronengine.CronExpressionParser;
import org.deliveroo.exceptions.InsufficientArgumentsException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new InsufficientArgumentsException("No arguments provided. A cron expression is required.");
        }

        CronExpressionParser parser = new CronExpressionParser();
        String output = parser.parse(args[0]);
        System.out.println(output);
    }
}

