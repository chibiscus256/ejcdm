package homework10;

import java.util.ArrayList;
import java.util.Comparator;

public class Pentathlon {
    static ArrayList<Sport> sports;

    static {
        sports = new ArrayList<>();
        sports.add(new Archery());
        sports.add(new Concour());
        sports.add(new Fencing());
        sports.add(new Running());
        sports.add(new Swimming());
    }

    public static void contest(ArrayList<Sportsman> sportsmen) {
        for (Sport sport : sports) {
            sport.contest(sportsmen);
        }
    }

    public static Sportsman getWinner(ArrayList<Sportsman> sportsmen) {
        return sportsmen.stream().max(Comparator.comparingInt(Sportsman::getScore)).get();
    }
}