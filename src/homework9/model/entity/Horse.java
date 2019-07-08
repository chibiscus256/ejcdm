package homework9.model.entity;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Horse implements Callable<Horse>, RaceEntity {

    private final static int TICK_TIME = 5;

    private CyclicBarrier barrier;
    private Random random = new Random();
    private float baseSpeed;
    private float distance;
    private float polygonLength;
    private int time;

    public Horse(CyclicBarrier barrier, float baseSpeed, float polygonLength) {
        this.barrier = barrier;
        this.baseSpeed = baseSpeed;
        this.polygonLength = polygonLength;
    }

    @Override
    public float getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "baseSpeed=" + baseSpeed +
                '}';
    }

    @Override
    public Horse call() throws Exception {
        while (true) {
            distance += baseSpeed * TICK_TIME * random.nextFloat();
            try {
                TimeUnit.MILLISECONDS.sleep(TICK_TIME);
                time += TICK_TIME;
                if(distance >= polygonLength) {
                    barrier.await();
                    return this;
                }
            } catch (InterruptedException | BrokenBarrierException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}