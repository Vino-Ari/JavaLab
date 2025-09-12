package Lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Lab2_4 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = random.nextInt(1001);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int number : array) {
            if (number % 10 == 3) result.add(number);
        }
        result.sort(Collections.reverseOrder());
        System.out.println(result);
    }
}
