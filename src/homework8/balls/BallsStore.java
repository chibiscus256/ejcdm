package homework8.balls;

import homework8.balls.Ball;

public abstract class BallsStore {
    public Ball takeBall(final int number) {
        return createBall(number);
    }

    protected abstract Ball createBall(final int number);
}