package homework8.balls;

public class BallsFactory extends BallsStore {
    @Override
    protected Ball createBall(final int number) {
        return number == 2 || number == 7 ? new WickedBall(number) : new GeneralBall(number);
    }
}