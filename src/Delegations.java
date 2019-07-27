import java.io.*;
import java.util.Scanner;

class Delegations {

    // Returns factorial
    // of the number
    static int fact(int n){
        int fact = 1;
        for (int i = 2; i <= n; i++)
            fact *= i;
        return fact;
    }

    // Function to calculate ncr
    static int ncr(int n, int r){
         return fact(n) / (fact(r) * fact(n - r));
    }

    // Function to calculate
    // the total possible ways
    static int ways(int m, int w) {
        if (w == 0 || m == 0){
            return 0;
        }
        return ncr(m, 2) * ncr(w, 1) + ncr(m, 1) * ncr(w, 2);
    }

    // Driver code
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("мужчин: ");
        int m = scanner.nextInt();
        System.out.println("женщин: ");
        int w = scanner.nextInt();
        System.out.println(ways(m, w));
    }
}