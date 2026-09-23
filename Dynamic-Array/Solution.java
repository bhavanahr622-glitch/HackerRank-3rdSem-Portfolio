import java.io.*;
import java.util.*;

public class Solution {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

        List<List<Integer>> seq = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            seq.add(new ArrayList<>());
        }

        int lastAnswer = 0;
        List<Integer> result = new ArrayList<>();

        for (List<Integer> query : queries) {

            int type = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            int index = (x ^ lastAnswer) % n;

            if (type == 1) {
                seq.get(index).add(y);
            } else {
                int size = seq.get(index).size();

                lastAnswer = seq.get(index).get(y % size);
                result.add(lastAnswer);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine =
            bufferedReader.readLine().trim().split(" ");

        int n = Integer.parseInt(firstLine[0]);
        int q = Integer.parseInt(firstLine[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {

            String[] values =
                bufferedReader.readLine().trim().split(" ");

            List<Integer> query = new ArrayList<>();

            for (String value : values) {
                query.add(Integer.parseInt(value));
            }

            queries.add(query);
        }

        List<Integer> result = dynamicArray(n, queries);

        for (int value : result) {
            System.out.println(value);
        }

        bufferedReader.close();
    }
}
