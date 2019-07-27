package homework9;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RaceTrack {

    private static int numberOfLaps = 5;
    private static int bet;
    private static int balance = 100;
    private static int lapDistance = 1000;
    private String[] names = {"Sugar", "Spirit", "Plotva", "Butsefal", "Trojan"};
    private HorseFactory factory = new HorseFactory();
    private List<Horse> horseList = factory.initList(names);
    private String chosenHorse = null;

    private void calculateResult() {
        for (Horse horse : horseList) {
            int allTime = 0;
            for (int lap = 0; lap < numberOfLaps; lap++) {
                int lapTime;
                double speedModifier = Math.random() + 0.1;
                horse.setCurrentSpeed((int) (horse.getMaxSpeed() * speedModifier) + 5);
                lapTime = lapDistance / horse.currentSpeed;
                allTime += lapTime;
                horse.setTime(allTime);
            }
            System.out.println(horse.getName() + ", time: " + horse.getTime());
        }

        Collections.sort(horseList);
        Horse winner = horseList.get(0);
        System.out.println("\nWinner is: " + winner.getName() + " with time: " + winner.getTime());

        if (winner.getName().equals(chosenHorse)) {
            System.out.println("Congratulations!");
            balance += bet * 2;
        } else {
            System.out.println("Sorry, you're not a winner");
            balance -= bet;
        }
    }

    void printConsole() {
        System.out.println("Welcome to horse race!");
        System.out.println("Your balance is: " + balance);
        System.out.println("We have these horses: ");
        for (Horse horse : horseList) {
            System.out.println(horse.name + ", maxSpeed: " + horse.maxSpeed);
        }
    }

    public void start(BufferedReader bufferedReader) {
        boolean valid = false;

        while (!valid) {
            System.out.println("Set your bet: ");
            try {
                bet = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException | IllegalArgumentException e) {
                System.err.println("Illegal argument");
            }
            if (bet <= balance && bet > 0) {
                valid = true;
                break;
            } else {
                System.err.println("You don't have enough money, try again");
            }
        }
        valid = false;
        String chosenHorse = null;
        while (!valid) {
            System.out.println("Choose horse: ");
            try {
                chosenHorse = bufferedReader.readLine();
            } catch (IOException | IllegalArgumentException e) {
                System.err.println("Illegal argument");
            }
            Iterator<Horse> iterator = horseList.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getName().equalsIgnoreCase(chosenHorse)) {
                    valid = true;
                    break;
                }
                if (!iterator.hasNext())
                    System.err.println("This horse is unavailable");
            }
        }
        calculateResult();
    }

    static int getBalance() {
        return balance;
    }
}