package homework9;

import homework9.model.GameMenu;
import homework9.model.display.Displayer;
import homework9.model.entity.Horse;
import homework9.model.display.ProgressDisplayer;
import homework9.model.RaceTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Main {

    private final static int HORSE_COUNT = 6;
    private final static float POLYGON_LENGTH = 100000.f;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(HORSE_COUNT);

        List<Horse> horses = new ArrayList<Horse>(HORSE_COUNT) {{
            add(new Horse(barrier, 15, POLYGON_LENGTH));
            add(new Horse(barrier, 24, POLYGON_LENGTH));
            add(new Horse(barrier, 19, POLYGON_LENGTH));
            add(new Horse(barrier, 7, POLYGON_LENGTH));
            add(new Horse(barrier, 10, POLYGON_LENGTH));
        }};

        Displayer displayable = new ProgressDisplayer(POLYGON_LENGTH, 150);
        RaceTrack<Horse> track = new RaceTrack<>(horses, barrier, POLYGON_LENGTH, displayable);

        GameMenu menu = new GameMenu(track);
        menu.start(horses);
    }
}