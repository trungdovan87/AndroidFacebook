package com.beautydroid.caramel.common.common;

import java.util.Objects;

public class ScreenOutputs {
    public static void print(String s, Object... objects) {
        System.out.printf(s, objects);
    }
    public static void print(Object object) {
        System.out.print(object);
    }

    public static void println(String s, Object... objects) {
        System.out.printf(s + "%n", objects);
    }

    public static void println(Object object) {
        System.out.println(object);
    }
}
