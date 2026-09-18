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
  
    public static List<Integer> maxSubarray(List<Integer> arr) {
    int current = arr.get(0);
int maxSubarray = arr.get(0);

int maxPositiveSum = 0;
int maxElement = arr.get(0);

for (int i = 0; i < arr.size(); i++) {
    int value = arr.get(i);

    if (value > 0) {
        maxPositiveSum += value;
    }

    if (value > maxElement) {
        maxElement = value;
    }

    if (i > 0) {
        current = Math.max(value, current + value);

        if (current > maxSubarray) {
            maxSubarray = current;
        }
    }
}

int maxSubsequence;

if (maxPositiveSum > 0) {
    maxSubsequence = maxPositiveSum;
} else {
    maxSubsequence = maxElement;
}

List<Integer> result = new ArrayList<>();
result.add(maxSubarray);
result.add(maxSubsequence);

return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
