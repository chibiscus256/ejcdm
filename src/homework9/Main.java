package homework9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        boolean gameFlag = true;
        String stringFlag;
        RaceTrack raceTrack = new RaceTrack();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (gameFlag) {
                raceTrack.printConsole();
                raceTrack.start(bufferedReader);
                if (raceTrack.getBalance() <= 0) {
                    System.out.println("GAME OVER");
                    break;
                }
                System.out.println("wanna play again? Y/N");
                stringFlag = bufferedReader.readLine();
                gameFlag = booleanParsing(stringFlag);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Simple method for converting letter to boolean variable
     */
    static boolean booleanParsing(String s) {
        boolean parameter;
        if (s.equalsIgnoreCase("y")) {
            parameter = true;
        } else if (s.equalsIgnoreCase("n")) {
            parameter = false;
        } else {
            parameter = false;
            System.err.println("Illegal statement. Program has closed");
        }
        return parameter;
    }
}