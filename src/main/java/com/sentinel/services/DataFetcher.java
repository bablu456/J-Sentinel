package com.sentinel.services;

import com.sentinel.model.SystemMetrics;
import com.sentinel.utils.Logger; // Import zaroor karna

public class DataFetcher implements Runnable {

    // ... (Purana code same rahega variables ka)
    private final SystemMonitor monitor;
    private final SystemMetrics metrics;
    private static final double CRITICAL_THRESHOLD = 80.0; // Isko wapas 80 kar dena agar 0 kiya tha to

    public DataFetcher(SystemMetrics metrics) {
        this.metrics = metrics;
        this.monitor = new SystemMonitor();
        this.metrics.setOsName(monitor.getOsName());
    }

    @Override
    public void run() {
        try {
            // ... (RAM logic same rahega) ...
            long totalMem = monitor.getGlobalMemory().getTotal();
            long availableMem = monitor.getGlobalMemory().getAvailable();
            long usedMem = totalMem - availableMem;
            double ramPercentage = ((double)usedMem / totalMem) * 100;

            metrics.setRamUsage(monitor.formatBytes(usedMem) + " / " + monitor.formatBytes(totalMem));

            boolean isRamCritical = ramPercentage > CRITICAL_THRESHOLD;
            metrics.setRamCritical(isRamCritical);

            // LOGGING LOGIC FOR RAM
            if (isRamCritical) {
                Logger.log("CRITICAL", "High RAM Usage detected: " + String.format("%.2f%%", ramPercentage));
            }

            // ... (CPU Logic same rahega) ...
            double cpuLoad = monitor.getRawCpuLoad();
            metrics.setCpuLoad(String.format("%.2f%%", cpuLoad));

            boolean isCpuCritical = cpuLoad > CRITICAL_THRESHOLD;
            metrics.setCpuCritical(isCpuCritical);

            // LOGGING LOGIC FOR CPU
            if (isCpuCritical) {
                Logger.log("CRITICAL", "High CPU Load detected: " + String.format("%.2f%%", cpuLoad));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}