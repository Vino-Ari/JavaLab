package Lab1;

import java.util.Scanner;

public class Lab1_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = readPositiveInt(scanner, "Введите меньший номер билета:");
        if (N == -1) {
            scanner.close();
            return;
        }
        int M = readPositiveInt(scanner, "Введите больший номер билета:");
        if (M == -1) {
            scanner.close();
            return;
        }
        scanner.close();
        if (N > M) {
            System.out.println("некоректный ввод даных");
            return;
        }

        int count = 0;
        for (int i = N; i <= M; i++) {
            int number = i;
            int[] numbers = new int[6];
            for (int k = 5; k >= 0; k--) {
                numbers[k] = number % 10;
                number /= 10;
            }
            int sum1 = numbers[0] + numbers[1] + numbers[2];
            int sum2 = numbers[3] + numbers[4] + numbers[5];
            if (sum1 == sum2) count++;
        }
        System.out.println(count);
    }

    public static int readPositiveInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        if (!sc.hasNextInt()) {
            System.out.println("Ошибка: введите целое число.");
            return -1;
        }
        int number = sc.nextInt();
        if (number < 100000 || number > 999999) {
            System.out.println("Число должно быть шестизначным");
            return -1;
        }
        return number;
    }
}
