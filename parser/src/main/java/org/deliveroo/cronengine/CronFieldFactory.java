package org.deliveroo.cronengine;


import org.deliveroo.exceptions.InvalidFieldException;
import org.deliveroo.parsers.*;

import static org.deliveroo.utlis.CronConstants.*;


public class CronFieldFactory {
    public static BaseParser createField(String name) {
        switch (name) {
            case MINUTE:
                return new MinuteParser();
            case HOUR:
                return new HourParser();
            case DAY_OF_MONTH:
                return new DayParser();
            case MONTH:
                return new MonthParser();
            case DAY_OF_WEEK:
                return new WeekParser();
            case COMMAND:
                return new CommandParser();
            default:
                throw new InvalidFieldException(name);
        }
    }
}
