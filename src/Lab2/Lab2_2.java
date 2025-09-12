package Lab2;

import java.util.Arrays;
import java.util.Random;

public class Lab2_2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = random.nextInt(1001);
        }
        Arrays.sort(array);
        for (int i = 19; i >= 0; i--) {
            if (array[i] % 2 == 0) {
                System.out.printf("Максимальное четное число: %d", array[i]);
                return;
            }
        }
        System.out.println("В массиве нет чётных чисел.");
    }
}
