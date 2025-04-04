package edu.pucmm.dp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<String> memoryLeakList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Aplicación iniciada. PID: " + ProcessHandle.current().pid());

        while (true) {
            simuladorCpuLoad();
            simuladorMemoryLeak();
            try {
                Thread.sleep(100); // Simula trabajo regular
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void simuladorCpuLoad() {
        for (int i = 0; i < 1_000_000; i++) {
            Math.pow(Math.random(), Math.random());
        }
    }

    private static void simuladorMemoryLeak() {
        for (int i = 0; i < 1000; i++) {
            memoryLeakList.add("Elemento_" + System.nanoTime());
            memoryLeakList.add("Elemento_" + System.nanoTime());
            memoryLeakList.add("Elemento_" + System.nanoTime());
        }
    }
}
