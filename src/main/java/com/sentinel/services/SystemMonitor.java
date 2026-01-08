package com.sentinel.services;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import java.text.DecimalFormat;

public class SystemMonitor {

    private final SystemInfo systemInfo;
    private final HardwareAbstractionLayer hardware;
    private static final DecimalFormat df = new DecimalFormat("0.00"); // Number formatting ke liye

    public SystemMonitor() {
        this.systemInfo = new SystemInfo();
        this.hardware = systemInfo.getHardware();
    }

    public String getOsName() {
        return systemInfo.getOperatingSystem().toString();
    }

    public String getMemoryInfo() {
        GlobalMemory memory = hardware.getMemory();
        long totalMemory = memory.getTotal();
        long availableMemory = memory.getAvailable();
        long usedMemory = totalMemory - availableMemory;

        return "RAM: " + formatBytes(usedMemory) + " / " + formatBytes(totalMemory);
    }

    public String getCpuLoad() {
        CentralProcessor processor = hardware.getProcessor();
        // CPU snapshot lo -> Wait karo -> Doosra snapshot lo -> Compare karo
        long[] prevTicks = processor.getSystemCpuLoadTicks();

        try {
            Thread.sleep(1000); // 1 second wait taaki CPU usage calculate ho sake
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double cpuLoad = processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100;
        return "CPU Load: " + df.format(cpuLoad) + "%";
    }

    // Bytes ko GB/MB me convert karne ka helper method
    private String formatBytes(long bytes) {
        long limit = 1024L * 1024L * 1024L; // 1 GB
        if (bytes >= limit) {
            return df.format((double) bytes / limit) + " GB";
        } else {
            return df.format((double) bytes / (1024 * 1024)) + " MB";
        }
    }
    // SystemMonitor.java ke andar add karo:

    public oshi.hardware.GlobalMemory getGlobalMemory() {
        return hardware.getMemory();
    }

    public double getRawCpuLoad() {
        long[] prevTicks = hardware.getProcessor().getSystemCpuLoadTicks();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        return hardware.getProcessor().getSystemCpuLoadBetweenTicks(prevTicks) * 100;
    }
}