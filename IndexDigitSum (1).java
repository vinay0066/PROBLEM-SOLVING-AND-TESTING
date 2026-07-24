import java.util.Scanner;
public class IndexDigitSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int tempNumber = Math.abs(number);
        int evenIndexSum = 0;
        int oddIndexSum = 0;
        int index = 0;
        while (tempNumber > 0) {
            int digit = tempNumber % 10;
            if (index % 2 == 0) {
                evenIndexSum += digit;
            } else {
                oddIndexSum += digit;
            }
            tempNumber /= 10;
            index++;
        }
        System.out.println("Sum at EVEN indices (0, 2, 4...): " + evenIndexSum);
        System.out.println("Sum at ODD indices  (1, 3, 5...): " + oddIndexSum);
        scanner.close();
    }
}