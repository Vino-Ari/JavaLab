package Lab2;

import java.util.Random;

public class Lab2_1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = random.nextInt(1001);
        }
        int count = 0;
        int sum = 0;
        for (int number : array) {
            if (number > 100 && (number / 100 == number % 10)) {
                count++;
                sum += number;
            }
        }
        System.out.printf("количество и сумму трехзначных симметричных чисел: %d и %d ", count, sum);
    }
}
