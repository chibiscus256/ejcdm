package homework9;

import java.util.ArrayList;
import java.util.List;

public class HorseFactory {
    public Horse create(int maxSpeed, String name) {
        return new Horse(maxSpeed, name);
    }

    List<Horse> initList(String[] names) {
        List<Horse> horseList = new ArrayList<>();
        for (String name : names) {
            horseList.add(create((int) (Math.random() * 100), name));
        }
        return horseList;
    }
}