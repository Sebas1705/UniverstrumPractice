package com.sebss;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class TaskProducer {

    public static final int N_TASKS = 10;
    public static final int TASK_CREATION_INTERVAL_MAX = 500;

    private final Universtrum universtrumInstance;
    private final String producerId;

    private Thread producerThread;

    private List<Future<ComplexTaskResult>> submittedTasks = new ArrayList<>();

    public TaskProducer(Universtrum unverstrumInstance, String producerId) {
        this.universtrumInstance = unverstrumInstance;
        this.producerId = producerId;
    }

    public void start() {
        //TODO: Crear y arrancar un hilo que implemente el siguiente comportamiento para un Productor de tareas de Universtrum:
        // hacer N_TASKS veces.
            // Generar una ComplexTask (usar ComplexTaskRandomGenerator.generateRandomComplexTask()
            // Enviar la tarea a la instancia de Universtrum. (debe imprimir un mensaje indicando la tarea que se envia).
            // el hilo se bloqueará un tiempo aleatorio entre 100 y 500 milisegundos. (se puede utilizar el método sleepRandom).
        // Al acabar de enviar las tareas, se quedará a la espera de que se resuelvan las tareas enviadas por
        // este proceso, imprimiendo el resultado cuando estén finalizadas.
        // Cuando estén todas las tareas acabadas, el productor terminará diciendo que se ha completado todas sus tareas

    }


    public static void sleepRandom(long millis) {
        sleep((long) (Math.random() * millis));
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
