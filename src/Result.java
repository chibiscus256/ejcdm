import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'exam' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY v as parameter.
     */


    public static Integer exam(List<Integer> v) {
        Integer[] a = (Integer[])v.toArray(new Integer[v.size()]);
        int n = a.length;

        int[] onesUntilIndex = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            onesUntilIndex[i] = a[i - 1] == 1 ? onesUntilIndex[i - 1] + 1 : onesUntilIndex[i - 1];
        }

        int k = 0;
        for (int i = 0; i <= n; i++) {
            int your_ones = onesUntilIndex[i];
            int you_zeros = i - your_ones;
            int your_sum = your_ones - you_zeros;

            int friend_ones = onesUntilIndex[n] - your_ones;
            int friend_zeros = (n - i) - friend_ones;
            int friend_sum = friend_ones - friend_zeros;

            if (your_sum > friend_sum) {
                k = i;
                break;
            }
        }

        return k;
    }


    public static void main(String[] args) {

        int result = Result.exam(new ArrayList<Integer>(1));
    }
}