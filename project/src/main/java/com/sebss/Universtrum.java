package com.sebss;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

/**
 * Universtrum
 *
 * Sistema que modela el API de entrada al supercomputador para enviar tareas complejas para resolver.
 *
 */
public class Universtrum {

    private enum Status {
        READY, RUNNING, SHUTTING_DOWN, STOPPED;

    }

    private final int concurrencyLevel;
    private volatile Status status;


    //TODO: Implementar el mecanismo de ejecución de ComplexTask que deberán ejecutar los hilos
    //      Problema: ComplexTask devuelve un int en su metodo solve(),
    //                Pero Univestrum recibe ComplexTask y debe devolver ComplexTaskResult...
    //    ¿Podemos hacer que el hilo directamente ejecute ComplexTasks? ¿es ComplexTask un Runnable o Callable?
    //    Necesitaremos un tipo especial de tareas que represente un Callable<ComplexTaskResult> y devuelva el
    //    tipo de resultado especídico.
    // Hint: ComplexTaskExecutor implements Callable<ComplexTaskResult>
    // ¿Qué referencias externas necesitamos al crear la tarea?
    // ¿Cómo vamos a gestionar el control del tiempo que lleva la tarea ejecutándose y esperando a ser ejecutada?

    public Universtrum(int concurrencyLevel) {
        this.concurrencyLevel = concurrencyLevel;
        status = Status.READY;
    }

    // TODO: Crear un un sistema de los hilos que ejecutarán las tareas

    //       y una estructura de datos que mantenga las tareas encoladas

    //TODO Definir un método que permita añadir una ComplexTask al supercomputador.
    //      La llamada a este método debe ser asíncrona, el hilo que llama a este método no debe bloquearse esperando
    //      a que esté el resultado listo, sino que deberá añadir la tarea a la lista de tareas
    //      Si la instancia de Universtrum está parada o está parando, la invocación al método rechazará
    //      la tarea suministrada o, de forma alternativa, hará que la ejecute de forma inmediata el hilo que invoca a
    //      este método.

    //public ??? submit(ComplexTask task)  {}

    public Status getStatus() {
        return status;
    }

    public Collection<ComplexTask> getPendingTasks() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     *  Cuando se invoque al método start, Univestrum arrancará tantos hilos como nCores.
     * Los hilos irán ejecutando las tareas que se hayan enviado previamente, si las hay
     * Si no las hay, los hilos de ejecución quedarán bloqueados a la espera de que se envíen más tareas.
     * Los hilos siempre deben ejecutar las tareas de mayor prioridad de las que se hayan enviado.
     * Dentro de las tareas con la misma prioridad, se ejecutarán utilizando la política FIFO, es decir, se ejecutará la
     * más antigua de todas las que tienen la misma prioridad.
     */
    public void start() {
        throw new UnsupportedOperationException("Not implemented yet");
    };

    /**
     * Al invocar este método, la instancia de universtrum no aceptará más tareas, pero ejecutará todas las que ya hayan
     * sido recibidas con anterioridad.
     *
     * Si el parametro immediate está a true, entonces se esperará a que terminen de ejecutarse todas aquellas que ya
     * estén en ejecución, y se retornarán como resultado todas las tareas que estuviesen pendientes de ejecución
     *
     * La invocación de este método debe de ser asíncrona, es decir, se debe cambiar el estado a SHUTTING_DOWN,
     * y retornar la función. Los hilos restantes deberán acabar de ejecutar las tareas pendientes, y cuando acaben todas
     * las tareas, el estado de Universum pasará a STOPPED.
     *
     */
    public void shutdown() {
        // Marcar la instancia como SHUTTING_DOWN
        // ¿Hay que actualizar el sistema de hilos para que notificar que estamos en proceso de apagado?

        // ¿Cómo comprobar de forma asíncrona que se acaban todas las tareas para despúes, pasar el estado a STOPPED?

        throw new UnsupportedOperationException("Not implemented yet");
    }

}
