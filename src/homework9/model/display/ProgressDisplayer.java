package homework9.model.display;

public class ProgressDisplayer implements Displayer {

    private final static char before = '#';
    private final static char after = '.';

    private float total;
    private int displaySize;

    public ProgressDisplayer(float total, int displaySize) {
        this.total = total;
        this.displaySize = displaySize;
    }

    @Override
    public void display(String name, float data) {
        float percent = data / total;
        int numberOfSymbols = (int) (percent * displaySize);
        System.out.print("[ ");
        for (int i = 0; i < numberOfSymbols; i++) {
            System.out.print(before);
        }
        for (int i = numberOfSymbols; i < displaySize; i++) {
            System.out.print(after);
        }
        System.out.println(" ] " + name);
    }

}