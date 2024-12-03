package org.deliveroo;

import org.deliveroo.exceptions.InvalidCronExpressionException;
import org.deliveroo.utlis.CronExpressionValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CronExpressionValidatorTest {

    @Test
    void testValidExpression() {
        assertDoesNotThrow(() -> CronExpressionValidator.validateExpression("*/15 0 1,15 * 1-5 /usr/bin/find"));
    }

    @Test
    void testInvalidFieldRange() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CronExpressionValidator.validateExpression("*/15 0 32 * 1-5 /usr/bin/find");
        });
        assertTrue(exception.getMessage().contains("Day of Month value out of range"));
    }

    @Test
    void testInvalidExpressionLength() {
        Exception exception = assertThrows(InvalidCronExpressionException.class, () -> {
            CronExpressionValidator.validateExpression("*/15 0 1,15 *");
        });
        assertTrue(exception.getMessage().contains("Invalid cron expression length"));
    }
}
