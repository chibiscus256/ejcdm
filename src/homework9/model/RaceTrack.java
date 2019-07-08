package homework9.model;

import homework9.model.display.Displayer;
import homework9.model.entity.Horse;
import homework9.model.entity.RaceEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class RaceTrack<T extends Callable & RaceEntity> {
    private final CyclicBarrier barrier;
    private final float length;
    private final List<T> participants;
    private final Displayer display;

    public RaceTrack(List<T> participants, CyclicBarrier barrier, float length, Displayer display) {
        this.participants = participants;
        this.barrier = barrier;
        this.length = length;
        this.display = display;
    }

    public Horse performRace() {
        ExecutorService service = Executors.newCachedThreadPool();
        CompletionService<Horse> completionService = new ExecutorCompletionService<>(service);
        participants.forEach(completionService::submit);

        Thread displayThread = new Thread(() -> {
            while (true) {
                System.out.println("--------------------------------");
                participants.forEach(participant -> display.display(participant.toString(), participant.getDistance()));
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        displayThread.setDaemon(true);
        displayThread.start();

        Horse winner = null;
        try {
            Future<Horse> result = completionService.take();
            winner = result.get();
            System.out.println(winner + " is winner");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
        return winner;
    }
}