package homework8.balls;

public abstract class Ball implements Comparable<Ball> {
    int number;
    int trick;

    public int getNumber() {
        return number;
    }

    public int getTrick() {
        return trick;
    }

    @Override
    public int compareTo(final Ball o) {
        return Integer.compare(this.number, o.number);
    }
}
