package homework2;

public class Task3_3 {

    private static boolean a = true;
    private static boolean b = false;
    private static boolean c = false;

    public static void main(String[] args) {
        System.out.println("first expression: " + (!a & b));
        System.out.println("second expression: " + (a || !b));
        System.out.println("third expression: " + (a & b || c));
    }
}
