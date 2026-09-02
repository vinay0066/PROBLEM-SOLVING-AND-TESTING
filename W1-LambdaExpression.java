import java.io.*;
import java.util.*;

public class Solution {

    interface PerformOperation {
        boolean check(int a);
    }

    public static PerformOperation isOdd() {
        return (a) -> a % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return (a) -> {
            if (a < 2) {
                return false;
            }

            for (int i = 2; i * i <= a; i++) {
                if (a % i == 0) {
                    return false;
                }
            }

            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return (a) -> {
            int original = a;
            int reverse = 0;

            while (a > 0) {
                reverse = reverse * 10 + a % 10;
                a /= 10;
            }

            return original == reverse;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int condition = sc.nextInt();
            int number = sc.nextInt();

            PerformOperation operation;

            if (condition == 1) {
                operation = isOdd();
                System.out.println(operation.check(number) ? "ODD" : "EVEN");

            } else if (condition == 2) {
                operation = isPrime();
                System.out.println(operation.check(number) ? "PRIME" : "COMPOSITE");

            } else {
                operation = isPalindrome();
                System.out.println(operation.check(number) ? "PALINDROME" : "NOT PALINDROME");
            }
        }

        sc.close();
    }
}
