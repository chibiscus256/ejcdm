package homework10;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Sportsman> sportsmen = new ArrayList<>();
        for (int i = 0; i < 20; ++i) {
            sportsmen.add(new Sportsman("Sportsman" + i));
        }

        Pentathlon.contest(sportsmen);
        Sportsman winner = Pentathlon.getWinner(sportsmen);
        System.out.println("The winner is: " + winner +
                ". Final score: " + winner.getScore());
    }
}