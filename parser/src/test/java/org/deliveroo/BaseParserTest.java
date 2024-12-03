package org.deliveroo;

import org.deliveroo.parsers.DayParser;
import org.deliveroo.parsers.HourParser;
import org.deliveroo.parsers.MinuteParser;
import org.deliveroo.parsers.MonthParser;
import org.junit.jupiter.api.Test;

import static org.deliveroo.TestUtils.normalizeWhitespace;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseParserTest {

    @Test
    void testParseWildcard() {
        MinuteParser parser = new MinuteParser();
        String result = normalizeWhitespace(parser.parse("*"));

        String expected = normalizeWhitespace("minute 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59");

        assertEquals(expected, result);
    }

    @Test
    void testParseRange() {
        HourParser parser = new HourParser();
        String result = normalizeWhitespace(parser.parse("0-5"));

        String expected = normalizeWhitespace("hour 0 1 2 3 4 5");

        assertEquals(expected, result);
    }

    @Test
    void testParseCommaSeparatedValues() {
        DayParser parser = new DayParser();
        String result = normalizeWhitespace(parser.parse("1,15,20"));

        String expected = normalizeWhitespace("day of month 1 15 20");

        assertEquals(expected, result);
    }

    @Test
    void testParseStep() {
        MonthParser parser = new MonthParser();
        String result = normalizeWhitespace(parser.parse("1-12/3"));

        String expected = normalizeWhitespace("month 1 4 7 10");

        assertEquals(expected, result);
    }

}
