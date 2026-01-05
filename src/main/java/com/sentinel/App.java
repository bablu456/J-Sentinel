package com.sentinel;

import com.sentinel.services.SystemMonitor;

public class App {
    public static void main(String[] args){
        System.out.println("J-Sentinel System Monitor Initializing...");
        SystemMonitor monitor = new SystemMonitor();

        System.out.println("OS: "+ monitor.getOsName());
        System.out.println(monitor.getMemoryInfo());
        System.out.println("Measuring CPU (Please wait 1 second)...");
        System.out.println(monitor.getCpuLoad());
    }
}
