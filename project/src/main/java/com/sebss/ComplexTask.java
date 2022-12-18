package com.sebss;

/**
 * Clase que representa una tarea complea a resolver por Universtrum
 */
public class ComplexTask {

    private final String taskId;
    private final int expectedSolution;
    private final long computationCostInMillis;

    public ComplexTask(String taskId, int expectedSolution, long costInMillis) {
        this.taskId = taskId;
        this.expectedSolution = expectedSolution;
        this.computationCostInMillis = costInMillis;
    }

    public String getTaskId() {
        return taskId;
    }

    public int solve() {
        //TODO: Para simular la resolución de la tarea, el hilo que ejecute este método deberá devolver
        //      el valor de expectedSolution después de que pasaen costInMillis milisegundos.
        // Se puede utilizar la función sleep
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public String toString() {
        return "ComplexTask{" +
                "taskId='" + taskId + '\'' +
                ", expectedSolution=" + expectedSolution +
                ", computationCostInMillis=" + computationCostInMillis +
                '}';
    }
}
