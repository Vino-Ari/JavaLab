package Lab1;

import java.util.Scanner;

public class Lab1_4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = readPositiveInt(scanner, "Введите количество этажей в доме: ");
            if (N == -1) {
                scanner.close();
                return;
            }

            int M = readPositiveInt(scanner, "Введите номер квартиры: ");
            if (M == -1) {
                scanner.close();
                return;
            }
            scanner.close();
            if (M > N * 3) {
                System.out.println("Такой квартиры нет в доме");
                return;
            }

            int floor = (M - 1) / 3 + 1;
            int elevatorFloor = (floor % 2 == 0) ? floor - 1 : floor;
            System.out.printf("Лифт приедет на %d этаж", elevatorFloor);
        }
    }

    public static int readPositiveInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        if (!sc.hasNextInt()) {
            System.out.println("Ошибка: введите целое число.");
            return -1;
        }
        int v = sc.nextInt();
        if (v <= 0) {
            System.out.println("Значение должно быть больше 0.");
            return -1;
        }
        return v;
    }
}
