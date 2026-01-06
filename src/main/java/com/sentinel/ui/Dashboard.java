package com.sentinel.ui;

import com.sentinel.services.SystemMonitor;
import com.sentinel.utils.ConsoleUtils;

public class Dashboard {

    // Ye method data lega aur screen par draw karega
    public void render(SystemMonitor monitor) {
        // Screen saaf karo
        ConsoleUtils.clearScreen();

        // Header print karo
        ConsoleUtils.printHeader();

        System.out.println(""); // Empty line

        // System Info Section
        System.out.println(ConsoleUtils.YELLOW + "[ SYSTEM DETAILS ]" + ConsoleUtils.RESET);
        System.out.println("OS Name:    " + monitor.getOsName());
        System.out.println("");

        // Resources Section (Table format)
        System.out.println(ConsoleUtils.YELLOW + "[ LIVE RESOURCES ]" + ConsoleUtils.RESET);
        System.out.printf("RAM Usage:  %s%n", monitor.getMemoryInfo());
        System.out.printf("CPU Load:   %s%n", monitor.getCpuLoad());

        System.out.println("");
        System.out.println(ConsoleUtils.CYAN + "----------------------------------------" + ConsoleUtils.RESET);
        System.out.println("Press 'Ctrl + C' to exit.");
    }
}