package homework9.model;

import homework9.model.entity.Horse;

import java.util.List;
import java.util.Scanner;

public class GameMenu {

    private int money = 1000;
    private homework9.model.RaceTrack track;

    public GameMenu(homework9.model.RaceTrack<Horse> track) {
        this.track = track;
    }

    public void start(List<Horse> list) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the horse racing.");
            int horseIndex;
            do {
                System.out.println("Please, choose your horse: (1-" + list.size() + ")");
                horseIndex = scanner.nextInt() - 1;
            } while (horseIndex < 0 || horseIndex >= list.size());

            int bet;
            do {
                System.out.println("Select your bet: (you have " + money + "$)");
                bet = scanner.nextInt();
            } while (bet < 0 || bet >= money);

            money -= bet;

            String symbol;
            do {
                System.out.println("Press Y to start race");
                symbol = scanner.next();
            } while (!symbol.equals("Y"));

            Horse winner = track.performRace();
            if(winner.equals(list.get(horseIndex))) {
                money += bet * 2;
            }
        }
    }
}