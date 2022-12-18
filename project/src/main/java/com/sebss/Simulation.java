package com.sebss;

public class Simulation {

    private static final int N_THREADS = 5; // Math.min(2, Runtime.getRuntime().availableProcessors() - 1);
    private static final int N_PRODUCERS = 1;
    public static final int MONITOR_INTEERVAL_MS = 1_000;
    public static final int UNIVERSTRUM_EXECUTION_TIME_MS = 50_000;
    public static final int UNIVERSTRUM_SHUTDOWN_MONITOR_TIME = 5_000;


    public static void main(String[] args) {

        //Se crea la instancia de Univestrum, inicializada con N_TREADS.
        Universtrum universtrum = new Universtrum(N_THREADS);
        universtrum.start();

        //Crear un Monitor, que monitorizará e imprimirá el estado de la instancia de Universtrum cada segundo.
        Monitor monitor = new Monitor(universtrum, MONITOR_INTEERVAL_MS);
        //Arrancar el monitor de la instancia de Universtrum.
        monitor.startMonitor();

        //Crear varios productores, que comenzarán a enviar tareas.
        for (int i = 0; i < N_PRODUCERS; i++) {
            new TaskProducer(universtrum, "Producer_" + i).start();
        }
        System.out.println("All producers started");

        sleep(UNIVERSTRUM_EXECUTION_TIME_MS);
        universtrum.shutdown();
        System.out.println("Shutdown signal sent to Universtrum instance");

        sleep(UNIVERSTRUM_SHUTDOWN_MONITOR_TIME);
        monitor.stopMonitor();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

}
