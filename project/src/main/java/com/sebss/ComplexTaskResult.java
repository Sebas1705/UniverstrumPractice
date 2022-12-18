package com.sebss;

/**
 * Clase que representa el resultado de haber ejecutado una tarea.
 *
 * No debería ser necesario modificar esta clase.
 */
public class ComplexTaskResult {

    /* Id de la tarea */
    private final String taskId;

    /* valor del resultado de la tarea */
    private final int value;
    /** Tiempo que ha tardado en ejecutarse la tarea */
    private final long executionTime;
    /** tiempo que ha estado la tarea esperando desde que se envió hasta que empezó a ejecutarse */
    private final long waitingTime;

    public ComplexTaskResult(String taskId, int result, long executionTime, long waitingTime) {
        this.taskId = taskId;
        this.value = result;
        this.executionTime = executionTime;
        this.waitingTime = waitingTime;
    }

    public int getValue() {
        return value;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    @Override
    public String toString() {
        return "ComplexTaskResult{" +
                "taskId='" + taskId + '\'' +
                ", value=" + value +
                ", executionTime=" + executionTime +
                ", waitingTime=" + waitingTime +
                '}';
    }
}
