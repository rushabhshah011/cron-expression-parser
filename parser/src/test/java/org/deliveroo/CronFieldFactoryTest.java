package org.deliveroo;


import org.deliveroo.cronengine.CronFieldFactory;
import org.deliveroo.exceptions.InvalidFieldException;
import org.deliveroo.parsers.BaseParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CronFieldFactoryTest {

    @Test
    void testValidFieldCreation() {
        BaseParser minuteParser = CronFieldFactory.createField("minute");
        assertNotNull(minuteParser);
        assertEquals("minute", minuteParser.name);

        BaseParser commandParser = CronFieldFactory.createField("command");
        assertNotNull(commandParser);
        assertEquals("command", commandParser.name);
    }

    @Test
    void testInvalidFieldCreation() {
        Exception exception = assertThrows(InvalidFieldException.class, () -> CronFieldFactory.createField("invalidField"));
        assertTrue(exception.getMessage().contains("Invalid field name"));
    }
}
