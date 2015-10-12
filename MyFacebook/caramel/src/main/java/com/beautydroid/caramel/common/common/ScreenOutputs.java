package com.beautydroid.caramel.common.common;

public class ScreenOutputs {
    public static void print(String s, Object... objects) {
        System.out.printf(s, objects);
    }

    public static void println(String s, Object... objects) {
        System.out.printf(s + "%n", objects);
    }
}
