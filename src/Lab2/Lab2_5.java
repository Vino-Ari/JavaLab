package Lab2;

import java.util.*;

public class Lab2_5 {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] array = new int[8][8];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(-10, 11);
            }
        }
        System.out.println("Исходная матрица");
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (isLocalMin(array, i, j)) {
                    count++;
                }
            }
        }
        System.out.printf("Количесвто локальных минимумов: %d", count);
    }

    public static boolean isLocalMin(int[][] array, int i, int j) {
        ArrayList<Integer> neighbors = new ArrayList<>();
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, array.length - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, array[0].length - 1); y++) {
                if (x != i || y != j) neighbors.add(array[x][y]);
            }
        }
        for (int number : neighbors) {
            if (array[i][j] >= number) return false;
        }
        return true;
    }

}
