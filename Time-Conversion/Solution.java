import java.io.*;
import java.util.*;

public class Solution {

    public static String timeConversion(String s) {

        int hour = Integer.parseInt(s.substring(0, 2));

        String rest = s.substring(2, 8);
        String period = s.substring(8, 10);

        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else {
            if (hour != 12) {
                hour += 12;
            }
        }

        return String.format("%02d%s", hour, rest);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine().trim();

        String result = timeConversion(s);

        System.out.println(result);

        bufferedReader.close();
    }
}
