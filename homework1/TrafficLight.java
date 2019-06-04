package homework1;

import org.jetbrains.annotations.Contract;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TrafficLight {
    private int minute;

    private void enterMinute() {

       System.out.println("Введите номер минуты");
       while (true) {
           try {
               Scanner scanMin = new Scanner(System.in);
               minute = scanMin.nextInt();
               if (minute <= 0) {
                   System.out.println("Номер минуты должен быть положительным числом");
               } else {
                   break;
               }
           } catch (InputMismatchException exception){
               System.out.println("Номер минуты должен быть целым числом больше нуля!");
           }
       }
   }

    @Contract(pure = true)
    private TrafficLightColor getColor() {

        if ((minute % 6 <= 2) & (minute > 0)) {
            return TrafficLightColor.RED;
        }
        else if (minute % 6 <= 3) {
            return TrafficLightColor.YELLOW;
        }
        else if (minute % 6 < 6) {
            return TrafficLightColor.GREEN;
        }
        return null;
    }

    public static void main(String[] args) {

        TrafficLight light = new TrafficLight();
        light.enterMinute();
        System.out.println(light.getColor());

    }
}
