package org.deliveroo.utlis;

import java.util.regex.Pattern;

public final class CronConstants {

    public static final Pattern NUMBER = Pattern.compile("\\d+");
    public static final Pattern RANGE = Pattern.compile("\\d+-\\d+");
    public static final Pattern STEP = Pattern.compile("(\\*|\\d+(-\\d+)?)/\\d+");
    public static final Pattern LIST = Pattern.compile("(\\d+|\\d+-\\d+|\\*/\\d+)(,(\\d+|\\d+-\\d+|\\*/\\d+))*");
    public static final Pattern WILDCARD = Pattern.compile("\\*");

    public static final int MIN_MINUTE = 0, MAX_MINUTE = 59;
    public static final int MIN_HOUR = 0, MAX_HOUR = 23;
    public static final int MIN_DAY = 1, MAX_DAY = 31;
    public static final int MIN_MONTH = 1, MAX_MONTH = 12;
    public static final int MIN_DOW = 0, MAX_DOW = 6;

    public static final String MINUTE = "minute";
    public static final String HOUR = "hour";
    public static final String DAY_OF_MONTH = "day of month";
    public static final String MONTH = "month";
    public static final String DAY_OF_WEEK = "day of week";
    public static final String COMMAND = "command";
}