package org.deliveroo;

import org.deliveroo.cronengine.CronExpressionParser;
import org.deliveroo.exceptions.InvalidCronExpressionException;
import org.junit.jupiter.api.Test;

import static org.deliveroo.TestUtils.normalizeWhitespace;
import static org.junit.jupiter.api.Assertions.*;

class CronExpressionParserTest {

    @Test
    void testValidExpression() {
        CronExpressionParser parser = new CronExpressionParser();
        String result = parser.parse("*/15 0 1,15 * 1-5 /usr/bin/find");

        String expected = """
                minute          0 15 30 45
                hour            0
                day of month    1 15
                month           1 2 3 4 5 6 7 8 9 10 11 12
                day of week     1 2 3 4 5
                command         /usr/bin/find
                """;

        assertEquals(normalizeWhitespace(expected), normalizeWhitespace(result));
    }

    @Test
    void testInvalidExpressionLength() {
        CronExpressionParser parser = new CronExpressionParser();
        String expression = "*/15 0 1,15 *";

        Exception exception = assertThrows(InvalidCronExpressionException.class, () -> parser.parse(expression));
        assertTrue(exception.getMessage().contains("Invalid cron expression length"));
    }

    @Test
    void testEmptyCommand() {
        CronExpressionParser parser = new CronExpressionParser();
        String expression = "*/15 0 1,15 * 1-5";

        Exception exception = assertThrows(InvalidCronExpressionException.class, () -> parser.parse(expression));
        assertTrue(exception.getMessage().contains("Invalid cron expression length"));
    }
}
