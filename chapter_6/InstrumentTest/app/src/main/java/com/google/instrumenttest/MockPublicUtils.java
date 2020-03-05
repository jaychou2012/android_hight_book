package com.google.instrumenttest;

import java.util.UUID;

public class MockPublicUtils {

    public int getUniqueId() {
        return UUID.randomUUID().version();
    }

    public int compareTo(int number) {
        if (number > 10) {
            return number;
        }
        return -1;
    }

    public int query(String s) {
        return s.length();
    }

    public void close() {

    }

    public void execute() {

    }
}
