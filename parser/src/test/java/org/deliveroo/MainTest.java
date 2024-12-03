package org.deliveroo;

import org.deliveroo.exceptions.InsufficientArgumentsException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.deliveroo.TestUtils.normalizeWhitespace;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void testMainWithValidExpression() {
        String[] args = {"*/15 0 1,15 * 1-5 /usr/bin/find"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Main.main(args);

        String output = normalizeWhitespace(outputStream.toString());
        assertTrue(output.contains("minute 0 15 30 45"));
        assertTrue(output.contains("command /usr/bin/find"));
    }

    @Test
    void testMainWithNoArguments() {
        String[] args = {};
        Exception exception = assertThrows(InsufficientArgumentsException.class, () -> Main.main(args));
        assertTrue(exception.getMessage().contains("No arguments provided"));
    }
}
