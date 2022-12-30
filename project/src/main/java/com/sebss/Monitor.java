package com.sebss;

/**
 * Clase que implementa el soporte para monitorizar el estado de una instancia de Unvierstrum
 */
public class Monitor {

    private final Universtrum universtrumInstance;
    private final long intervalInMillis;

    private Thread monitorThread;

    public Monitor(Universtrum instance, long intervalInMillis) {
        this.universtrumInstance = instance;
        this.intervalInMillis = intervalInMillis;
    }

    public void startMonitor() {
        //Deberá arrancar un hilo que compruebe e imprima el estado de la instancia de Universtrum
        // y cuantas tareas están pendientes de ejecución.
        // la invocación de este método debe de ser asincrona, el método debe arrancar el hilo de monitorización
        // y devolver la ejecución mientras se ejecuta el hilo de monitorización del estado.
        monitorThread = new Thread(() -> {
            System.out.println("Monitor Thread started\n");
            while (true) {
                try {
                    Thread.sleep(intervalInMillis);
                } catch (InterruptedException e) {break;}
                System.out.println("Monitor universtrum status : " + universtrumInstance.getStatus()
                        + " with " + universtrumInstance.getPendingTasks().size()
                        + " tasks waiting in queue\n");
            }
        },"monitorThread");
        monitorThread.start();
    }

    public void stopMonitor() {
        //Deberá parar el hilo de impresión del estado de la instancia de Universtrum.
        monitorThread.interrupt();
        System.out.println("Stopping monitor thread\n");
        try {
            monitorThread.join();
        } catch (InterruptedException e) {}
        System.out.println("Monitor thread Stopped\n");
    }
}
