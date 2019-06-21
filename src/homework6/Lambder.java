package homework6;

public class Lambder {

    public static void main(String[] args) {

        MathOperate division = (v1, v2) -> v1 / v2;
        division.getInfo();
        System.out.println(division.getResult(1, 1));
    }
}
