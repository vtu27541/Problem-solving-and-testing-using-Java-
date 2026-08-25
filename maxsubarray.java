import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
        // Kadane's algorithm for maximum subarray sum
        int currentSum = arr.get(0);
        int maxSubarraySum = arr.get(0);

        // Maximum subsequence sum
        int maxSubsequenceSum = arr.get(0);
        boolean hasPositive = arr.get(0) > 0;

        for (int i = 1; i < arr.size(); i++) {
            int value = arr.get(i);

            // Maximum subarray
            currentSum = Math.max(value, currentSum + value);
            maxSubarraySum = Math.max(maxSubarraySum, currentSum);

            // Maximum subsequence
            if (value > 0) {
                maxSubsequenceSum += value;
                hasPositive = true;
            }
        }

        // If all elements are negative,
        // choose the largest (least negative) element.
        if (!hasPositive) {
            maxSubsequenceSum = Collections.max(arr);
        }

        return Arrays.asList(maxSubarraySum, maxSubsequenceSum);
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
            new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
            );

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {

            int n = Integer.parseInt(
                bufferedReader.readLine().trim()
            );

            List<Integer> arr = Arrays.stream(
                    bufferedReader.readLine()
                        .trim()
                        .split("\\s+")
                )
                .map(Integer::parseInt)
                .collect(Collectors.toList());

            List<Integer> result = Result.maxSubarray(arr);

            bufferedWriter.write(
                result.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "))
            );

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
