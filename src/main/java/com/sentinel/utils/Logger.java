package com.sentinel.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String LOG_FILE = "system-health.log";
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String level, String message) {
        String timestamp = dtf.format(LocalDateTime.now());
        String logEntry = String.format("[%s] [%s] %s", timestamp, level, message);

        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(logEntry);

        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}