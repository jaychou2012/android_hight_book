package com.google.instrumenttest;

import java.util.UUID;

public class MockUtils {
    public static int getUniqueId() {
        return UUID.randomUUID().version();
    }

    public static int compareTo(int number) {
        if (number > 10) {
            return number;
        }
        return 0;
    }

    public static int query(String s) {
        return s.length();
    }

    public static void close() {

    }

    public static void execute() {

    }
}
