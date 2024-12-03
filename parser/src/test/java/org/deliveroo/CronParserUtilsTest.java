package org.deliveroo;

import org.deliveroo.utlis.CronParserUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CronParserUtilsTest {

    @Test
    void testCommaParser() {
        String result = CronParserUtils.commaParser("1,2,5", 0, 10);
        assertEquals("1 2 5", result);
    }

    @Test
    void testStepParser() {
        String result = CronParserUtils.stepParser("0-10/2", 0, 10);
        assertEquals("0 2 4 6 8 10", result);
    }

    @Test
    void testRangeParser() {
        String result = CronParserUtils.rangeParser("3-7", 0, 10);
        assertEquals("3 4 5 6 7", result);
    }

    @Test
    void testUniverseParser() {
        String result = CronParserUtils.universeParser(0, 5);
        assertEquals("0 1 2 3 4 5", result);
    }
}
