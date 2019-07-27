package homework9;

import java.util.Objects;

public class Horse implements Comparable<Horse> {
    int maxSpeed;
    int currentSpeed;
    public String name;
    private int time;

    public Horse() {
    }

    Horse(int maxSpeed, String name) {
        this.maxSpeed = maxSpeed;
        this.name = name;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    int getTime() {
        return time;
    }

    void setTime(int time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return maxSpeed == horse.maxSpeed &&
                Objects.equals(name, horse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxSpeed, name);
    }

    @Override
    public int compareTo(Horse o) {
        return Integer.compare(this.getTime(), o.getTime());
    }
}