import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int m = matrix.size();
        int n = matrix.get(0).size();

        int[][] result = new int[m][n];

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            int top = layer;
            int bottom = m - 1 - layer;
            int left = layer;
            int right = n - 1 - layer;

            List<Integer> elements = new ArrayList<>();

          
            for (int j = left; j <= right; j++) {
                elements.add(matrix.get(top).get(j));
            }

            
            for (int i = top + 1; i <= bottom; i++) {
                elements.add(matrix.get(i).get(right));
            }

            
            for (int j = right - 1; j >= left; j--) {
                elements.add(matrix.get(bottom).get(j));
            }

  
            for (int i = bottom - 1; i > top; i--) {
                elements.add(matrix.get(i).get(left));
            }

            int len = elements.size();
            int shift = r % len;

            int index = shift;

            
            for (int j = left; j <= right; j++) {
                result[top][j] = elements.get(index);
                index = (index + 1) % len;
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                result[i][right] = elements.get(index);
                index = (index + 1) % len;
            }

            
            for (int j = right - 1; j >= left; j--) {
                result[bottom][j] = elements.get(index);
                index = (index + 1) % len;
            }

            
            for (int i = bottom - 1; i > top; i--) {
                result[i][left] = elements.get(index);
                index = (index + 1) % len;
            }
        }

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput =
                bufferedReader.readLine()
                        .trim()
                        .split("\\s+");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            String[] values =
                    bufferedReader.readLine()
                            .trim()
                            .split("\\s+");

            List<Integer> row = new ArrayList<>();

            for (String value : values) {
                row.add(Integer.parseInt(value));
            }

            matrix.add(row);
        }

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
