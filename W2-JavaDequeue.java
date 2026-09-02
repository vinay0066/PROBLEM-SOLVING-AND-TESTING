import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxUnique = 0;
        for (int i = 0; i < M; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        maxUnique = map.size();
        for (int i = M; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            int remove = arr[i - M];
            map.put(remove, map.get(remove) - 1);
            if (map.get(remove) == 0) {
                map.remove(remove);
            }
            maxUnique = Math.max(maxUnique, map.size());
        }
        System.out.println(maxUnique);
        sc.close();
    }
}
