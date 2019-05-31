package homework2;

public class Task3_24 {

    private static boolean[] firstArgument = {true, false};
    private static boolean[] secondArgument = {true, false};
    private static boolean[] thirdArgument = {true, false};

    public static void main(String[] args) {
        for (boolean i: firstArgument){
            for (boolean j: secondArgument)
                for (boolean k: thirdArgument){
                System.out.println("X = " + i + " Y = " + j + " Z = " + k + " не (Y или не X и Z) или Z = " + (!(j || !i & k) || k));
                System.out.println("X = " + i + " Y = " + j + " Z = " + k + " X и не (не Y или Z) или Y = " + (i & !(!j || k) || j));
                System.out.println("X = " + i + " Y = " + j + " Z = " + k + " не (X или Y и Z) или не X = " + (!(i || j & k) || !i));
            }
        }
    }
}
