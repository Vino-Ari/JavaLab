package Lab9;

import java.util.Arrays;

public class Lab9_1 {
    public static void main(String[] args) {
        int[] temperatureDiary = {-2, -5, -2, -4, 3, -6, -2,
                -1, 5, 1, 1, 0, -1, 0, 3, -1, 2, 5, 2, 4, 4, 0, 6, 1, 4, 6, -1, 2, 4, 7, 11};
        long count = Arrays.stream(temperatureDiary).filter(day -> day < 0).count();
        System.out.printf("количество дней с отрицательной температурой: %d\n", count);
        boolean result = Arrays.stream(temperatureDiary).anyMatch(day -> day > 10);
        System.out.println((result) ? "Было" : "Не было");
        long maxFirstWeek = Arrays.stream(temperatureDiary).limit(7).max().orElse(Integer.MIN_VALUE);
        System.out.printf("Максимальная температуру в первую неделю марта: %d", maxFirstWeek);
    }
}
