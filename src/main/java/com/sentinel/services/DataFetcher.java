package com.sentinel.services;

import com.sentinel.model.SystemMetrics;

public class DataFetcher implements Runnable {

    private final SystemMonitor monitor;
    private final SystemMetrics metrics;

    // Threshold Limit (80%)
    private static final double CRITICAL_THRESHOLD = 80.0;

    public DataFetcher(SystemMetrics metrics) {
        this.metrics = metrics;
        this.monitor = new SystemMonitor();
        this.metrics.setOsName(monitor.getOsName());
    }

    @Override
    public void run() {
        try {
            // 1. Raw Data lo
            // Note: Hamein yahan thoda logic badalna padega taaki raw numbers mil sakein
            // Lekin simplicity ke liye hum SystemMonitor se naya logic yahi likh dete hain

            // --- RAM LOGIC ---
            long totalMem = monitor.getGlobalMemory().getTotal();
            long availableMem = monitor.getGlobalMemory().getAvailable();
            long usedMem = totalMem - availableMem;

            double ramPercentage = ((double)usedMem / totalMem) * 100;

            // Set Text
            metrics.setRamUsage(monitor.formatBytes(usedMem) + " / " + monitor.formatBytes(totalMem));
            // Set Alert
            metrics.setRamCritical(ramPercentage > CRITICAL_THRESHOLD);

            // --- CPU LOGIC ---
            // Note: Hum SystemMonitor ka helper method use kar rahe the,
            // par ab hame raw percentage chahiye check karne ke liye.
            double cpuLoad = monitor.getRawCpuLoad(); // *Is method ko SystemMonitor me add karna padega, niche dekho

            // Set Text
            metrics.setCpuLoad(String.format("%.2f%%", cpuLoad));
            // Set Alert
            metrics.setCpuCritical(cpuLoad > CRITICAL_THRESHOLD);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}