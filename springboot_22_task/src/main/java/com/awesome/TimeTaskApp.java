package com.awesome;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTaskApp {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer task run");
            }
        };
        timer.schedule(task, 0, 2000);
    }
}
