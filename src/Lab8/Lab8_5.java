package Lab8;

import java.util.Scanner;

public class Lab8_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        String[] numbers = scanner.nextLine().split("\\D+");
        for (String number : numbers) {
            if (!number.isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }
        System.out.println("Ответ: " + sum);
        scanner.close();
    }
}
