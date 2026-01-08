package com.sentinel.model;

public class SystemMetrics {
    private volatile String ramUsage = "Calculating...";
    private volatile String cpuLoad = "Calculating...";
    private volatile String osName = "Calculating...";

    private volatile boolean isRamCritical = false;
    private volatile boolean isCpuCritical = false;

    public String getRamUsage() {
        return ramUsage;
    }
    public void setRamUsage(String ramUsage) {
        this.ramUsage = ramUsage;
    }
    public String getCpuLoad() {
        return cpuLoad;
    }
    public void setCpuLoad(String cpuLoad) {
        this.cpuLoad = cpuLoad;
    }
    public String getOsName() {
        return osName;
    }
    public void setOsName(String osName) {
        this.osName = osName;
    }
    public boolean isRamCritical() {
        return isRamCritical;
    }
    public void setRamCritical(boolean ramCritical) {
        isRamCritical = ramCritical;
    }
    public boolean isCpuCritical(){
        return isCpuCritical;
    }
    public void setCpuCritical(boolean cpuCritical){
        isCpuCritical = cpuCritical;
    }
}
