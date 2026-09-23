import java.io.*;
import java.util.*;

public class Solution {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        int alice = 0;
        int bob = 0;

        for (int i = 0; i < 3; i++) {

            if (a.get(i) > b.get(i)) {
                alice++;
            } else if (a.get(i) < b.get(i)) {
                bob++;
            }
        }

        List<Integer> result = new ArrayList<>();

        result.add(alice);
        result.add(bob);

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        String[] aValues =
            bufferedReader.readLine().trim().split(" ");

        String[] bValues =
            bufferedReader.readLine().trim().split(" ");

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (String value : aValues) {
            a.add(Integer.parseInt(value));
        }

        for (String value : bValues) {
            b.add(Integer.parseInt(value));
        }

        List<Integer> result = compareTriplets(a, b);

        System.out.println(result.get(0) + " " + result.get(1));

        bufferedReader.close();
    }
}
