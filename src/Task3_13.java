public class Task3_13 {

    private static boolean[] firstArgument = {true, false};
    private static boolean[] secondArgument = {true, false};

    public static void main(String[] args) {
        for (boolean i: firstArgument){
            for (boolean j: secondArgument){
                System.out.println("A = " + i + " B = " + j + " не (А и В) = " + !(i & j));
                System.out.println("A = " + i + " B = " + j + " не А или В = " + (!i || j));
                System.out.println("A = " + i + " B = " + j + " А или не В = " + (i || !j));
            }
        }
    }
}
