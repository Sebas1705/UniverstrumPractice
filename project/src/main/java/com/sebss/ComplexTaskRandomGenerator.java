package com.sebss;

import java.util.concurrent.ThreadLocalRandom;

/*
 * Clase de utilidad para generar Tareas aleatorias.
 *
 * No es necesario modificar esta clase
 */
public class ComplexTaskRandomGenerator {

    public static final ThreadLocalRandom randomizer = ThreadLocalRandom.current();
    public static final int COMPUTE_TIME_MIN = 100;
    public static final int COMPUTE_TIME_MAX = 5_000;

    public static ComplexTask generateRandomComplexTask(String ownerId, String taskId) {
        return new ComplexTask(
                ownerId + "_" + taskId,
                randomSolutionValue(),
                randomComputationCostTime());
    }

    private static int randomSolutionValue() {
        return randomizer.nextInt(100, 5_000);
    }

    private static int randomComputationCostTime() {
        return randomizer.nextInt(COMPUTE_TIME_MIN, COMPUTE_TIME_MAX);
    }

}
