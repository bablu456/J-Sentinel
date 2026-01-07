package com.sentinel.services;

import com.sentinel.model.SystemMetrics;

public class DataFetcher implements Runnable {

    private final SystemMonitor monitor;
    private final SystemMetrics metrics;

    public DataFetcher(SystemMetrics metrics){
        this.metrics = metrics;
        this.monitor = new SystemMonitor();
        this.metrics.setOsName(monitor.getOsName());
    }

    @Override
    public void run(){
        try{
            metrics.setRamUsage((monitor.getMemoryInfo()));
            metrics.setCpuLoad(monitor.getCpuLoad());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
