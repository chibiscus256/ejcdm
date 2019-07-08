package homework10;

import java.util.HashMap;
import java.util.Map;


public class Sportsman {

    String lastName;
    Map<String, Integer> scores;

    public Sportsman(String lastName) {
        this.lastName = lastName;
        scores = new HashMap<>();
    }

    public int getScore() {
        int result = 0;
        for (int score : scores.values()) {
            result += score;
        }
        return result;
    }

    @Override
    public String toString() {
        return lastName;
    }
}