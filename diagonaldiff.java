import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {

        int n = arr.size();

        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int i = 0; i < n; i++) {
            // Primary diagonal: [0][0], [1][1], [2][2], ...
            primaryDiagonal += arr.get(i).get(i);

            // Secondary diagonal: [0][n-1], [1][n-2], ...
            secondaryDiagonal += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(primaryDiagonal - secondaryDiagonal);
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
            new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(
                        bufferedReader.readLine()
                            .replaceAll("\\s+$", "")
                            .split(" ")
                    )
                    .map(Integer::parseInt)
                    .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}