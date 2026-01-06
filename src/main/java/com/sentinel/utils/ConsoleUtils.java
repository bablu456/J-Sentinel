package com.sentinel.utils;

public class ConsoleUtils {
    // Colors
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE_BOLD = "\033[1;37m";

    // Screen Clear karne ka magic code
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Header print karne ke liye
    public static void printHeader() {
        System.out.println(CYAN + "========================================" + RESET);
        System.out.println(WHITE_BOLD + "   J-SENTINEL SYSTEM MONITOR (v1.0)   " + RESET);
        System.out.println(CYAN + "========================================" + RESET);
    }
}