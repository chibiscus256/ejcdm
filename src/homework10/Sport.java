package homework10;

import java.util.ArrayList;
import java.util.Random;

public abstract class Sport {
    protected String name;
    protected Random randomizer = new Random();

    public void contest(ArrayList<Sportsman> sportsmen) {
        for (Sportsman sportsman: sportsmen) {
            int score = randomizer.nextInt(100);
            sportsman.scores.put(name, score);
        }
    }

    public String getName() {
        return name;
    }
}