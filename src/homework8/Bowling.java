package homework8;

import homework8.balls.Ball;
import homework8.balls.BallsFactory;
import homework8.balls.BallsStore;

import java.util.Set;
import java.util.TreeSet;

class Bowling {

    private Set<Ball> generalBalls = new TreeSet<>();
    private Set<Ball> trickBalls = new TreeSet<>();

    void simpleBallingStart() {
        prepareBallingBalls();
        removeBalls();
        System.out.print("\nTrick balls: ");
        for (Ball ball : trickBalls) {
            System.out.print(ball.getNumber() + "{trick: " + ball.getTrick() + "} " );
        }
    }

    void removeBalls(){
        System.out.print("General balls before removing: ");
        for (Ball ball : generalBalls) {
            System.out.print(ball.getNumber() + " ");
        }

        generalBalls.removeIf(bowl -> bowl.getNumber() == 3 || bowl.getNumber() == 17);

        System.out.print("\nGeneral balls after removing: ");
        for (Ball ball : generalBalls) {
            System.out.print(ball.getNumber() + " ");
        }
    }

    private void prepareBallingBalls() {
        BallsStore ballsStore = new BallsFactory();
        for (int i = 1; i < 20; i++) {
            if (i == 2 || i == 7) {
                trickBalls.add(ballsStore.takeBall(i));
            } else {
                generalBalls.add(ballsStore.takeBall(i));
            }
        }
    }
}
