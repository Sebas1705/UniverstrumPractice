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
        //TODO Deberá arrancar un hilo que compruebe e imprima el estado de la instancia de Universtrum
        // y cuantas tareas están pendientes de ejecución.
        // la invocación de este método debe de ser asincrona, el método debe arrancar el hilo de monitorización
        // y devolver la ejecución mientras se ejecuta el hilo de monitorización del estado.
        // Opcionalmente se imprimirá también el número de hilos que tiene Universtrum creados,
        // cuantos están ejecutando tareas y cuántos están "ociosos" esperando a que se envíen tareas nuevas
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void stopMonitor() {
        // TODO Deberá parar el hilo de impresión del estado de la instancia de Universtrum.
    }
}
