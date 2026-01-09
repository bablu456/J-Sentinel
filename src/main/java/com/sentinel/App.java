package com.sentinel;

import com.sentinel.model.SystemMetrics;
import com.sentinel.services.DataFetcher;
import com.sentinel.ui.Dashboard;
import com.sentinel.utils.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        Logger.log("INFO", "J-Sentinel Application Started.");

        System.out.println("Starting J-Sentinel Engines...");
        // 1. Shared Data Model (Box)
        SystemMetrics metrics = new SystemMetrics();

        // 2. Background Worker Setup (The Chef)
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        DataFetcher fetcher = new DataFetcher(metrics);

        // Har 1 second me data fetch karo (Background me)
        scheduler.scheduleAtFixedRate(fetcher, 0, 1, TimeUnit.SECONDS);

        // 3. UI Setup (The Waiter)
        Dashboard dashboard = new Dashboard();

        while (true) {
            dashboard.render(metrics);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}