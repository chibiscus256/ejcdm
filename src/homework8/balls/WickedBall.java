package homework8.balls;

import java.util.Random;

class WickedBall extends Ball {
    public WickedBall(final int number) {
        super.number = number;
        trick = new Random().nextInt(10);
    }
}