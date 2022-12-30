package com.sebss;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Future;

public class TaskProducer {

    public static final int N_TASKS = 20;
    public static final int TASK_CREATION_INTERVAL_MAX = 500;
    public static final int TIME_MAX_TRYING = 2000;

    private final Universtrum universtrumInstance;
    private final String producerId;

    private Thread producerThread;

    private List<Future<ComplexTaskResult>> submittedTasks = new ArrayList<>();

    public TaskProducer(Universtrum unverstrumInstance, String producerId) {
        this.universtrumInstance = unverstrumInstance;
        this.producerId = producerId;
    }

    public void start() {
        //Crear y arrancar un hilo que implemente el siguiente comportamiento para un Productor de tareas de Universtrum:
        // hacer N_TASKS veces.
            // Generar una ComplexTask (usar ComplexTaskRandomGenerator.generateRandomComplexTask()
            // Enviar la tarea a la instancia de Universtrum. (debe imprimir un mensaje indicando la tarea que se envia).
            // el hilo se bloqueará un tiempo aleatorio entre 100 y 500 milisegundos. (se puede utilizar el método sleepRandom).
        // Al acabar de enviar las tareas, se quedará a la espera de que se resuelvan las tareas enviadas por
        // este proceso, imprimiendo el resultado cuando estén finalizadas.
        // Cuando estén todas las tareas acabadas, el productor terminará diciendo que se ha completado todas sus tareas
        producerThread = new Thread(()->{

            for(int i=0;i<N_TASKS;i++){

                //Generamos la tarea y la enviamos:
                ComplexTask ct = ComplexTaskRandomGenerator.generateRandomComplexTask(producerId, "Task_"+i);
                Future<ComplexTaskResult> submit = universtrumInstance.submit(ct);

                //Primero se comprueba que se pueda enviar la tarea si no espera un tiempo y sale en caso de no cambiar.
                long start = System.currentTimeMillis();
                while(submit==null){
                    System.out.println("Producer "+producerId+" try to submit task while instance is not running");
                    sleep(TASK_CREATION_INTERVAL_MAX);
                    if(System.currentTimeMillis()-start>=TIME_MAX_TRYING)return; //Si paso el tiempo maximo sale sin hacer nada.
                    else submit = universtrumInstance.submit(ct); //Probamos a enviar de nuevo
                }

                //En caso de haber sido enviado se guarda
                submittedTasks.add(submit);
                System.out.println("Producer submitting "+ct+"\n");
                
                //Comprobamos si hay alguna tarea lista:
                ListIterator<Future<ComplexTaskResult>> listIterator = submittedTasks.listIterator();
                while(listIterator.hasNext()){
                    Future<ComplexTaskResult> f=listIterator.next();
                    if(f.isDone()){
                        try{
                            ComplexTaskResult ctr = f.get();
                            universtrumInstance.extractOne();
                            listIterator.remove();
                            System.out.println("Producer "+producerId+" has received result for "+ctr+"\n");
                            break; 
                        }catch(Exception e){
                            System.out.println("Error TaskProducer "+producerId+": "+e.getMessage());
                        }
                    }
                }

                sleepRandom(TASK_CREATION_INTERVAL_MAX);
            }
            //Hacemos la ultima comprobación esperando a que se cumpla la tarea:
            for (Future<ComplexTaskResult> f : submittedTasks) {
                try {
                    ComplexTaskResult ctr = f.get();
                    universtrumInstance.extractOne();
                    System.out.println("Producer "+producerId+" has received result for "+ctr+"\n");
                } catch (Exception e) {
                    System.out.println("Error TaskProducer "+producerId+": "+e.getMessage());
                }
            }
            System.out.println("Todas las tareas de "+producerId+" han sido ejecutadas\n");
        },"TaskProducer");

        producerThread.start();
        
    }



    public static void sleepRandom(long millis) {
        sleep((long) (Math.random() * (millis-100) + 100));
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }

}
