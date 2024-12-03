package org.deliveroo;

public class TestUtils {
    public static String normalizeWhitespace(String str) {
        return str.replaceAll("\\s+", " ").trim();
    }
}
