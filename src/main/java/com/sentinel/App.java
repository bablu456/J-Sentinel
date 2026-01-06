package com.sentinel;

import com.sentinel.services.SystemMonitor;
import com.sentinel.ui.Dashboard;


public class App {
    public static void main(String[] args){
        SystemMonitor monitor = new SystemMonitor();
        Dashboard dashboard = new Dashboard();

        while(true){
            dashboard.render(monitor);
            try{
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
