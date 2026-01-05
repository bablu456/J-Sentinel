package com.sentinel.services;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

public class SystemMonitor {

    private final SystemInfo systemInfo;
    private final HardwareAbstractionLayer hardware;

    public SystemMonitor() {
        // OSHI ka main object initialize kar rahe hain
        this.systemInfo = new SystemInfo();
        this.hardware = systemInfo.getHardware();
    }

    // Ye method bas verify karega ki OS kaunsa hai
    public String getOsName() {
        return systemInfo.getOperatingSystem().toString();
    }
}
