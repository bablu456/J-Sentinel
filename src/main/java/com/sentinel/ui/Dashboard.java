package com.sentinel.ui;

import com.sentinel.model.SystemMetrics;
import com.sentinel.utils.ConsoleUtils;
import java.awt.Toolkit; // Sound ke liye

public class Dashboard {

    public void render(SystemMetrics metrics) {
        ConsoleUtils.clearScreen();
        ConsoleUtils.printHeader();
        System.out.println("");

        System.out.println(ConsoleUtils.YELLOW + "[ SYSTEM DETAILS ]" + ConsoleUtils.RESET);
        System.out.println("OS Name:    " + metrics.getOsName());
        System.out.println("");

        System.out.println(ConsoleUtils.YELLOW + "[ LIVE RESOURCES ]" + ConsoleUtils.RESET);

        // --- RAM Display Logic ---
        String ramColor = metrics.isRamCritical() ? ConsoleUtils.RED : ConsoleUtils.GREEN;
        System.out.print("RAM Usage:  " + ramColor + metrics.getRamUsage() + ConsoleUtils.RESET);

        if (metrics.isRamCritical()) {
            System.out.print(ConsoleUtils.RED + " [WARNING: HIGH USAGE]" + ConsoleUtils.RESET);
            Toolkit.getDefaultToolkit().beep(); // Sound karega
        }
        System.out.println();

        // --- CPU Display Logic ---
        String cpuColor = metrics.isCpuCritical() ? ConsoleUtils.RED : ConsoleUtils.GREEN;
        System.out.print("CPU Load:   " + cpuColor + metrics.getCpuLoad() + ConsoleUtils.RESET);

        if (metrics.isCpuCritical()) {
            System.out.print(ConsoleUtils.RED + " [WARNING: OVERHEAT]" + ConsoleUtils.RESET);
            Toolkit.getDefaultToolkit().beep();
        }
        System.out.println();

        System.out.println("");
        System.out.println(ConsoleUtils.CYAN + "----------------------------------------" + ConsoleUtils.RESET);
        System.out.println("Press 'Ctrl + C' to exit.");
    }
}