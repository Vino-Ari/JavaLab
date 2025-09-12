package Lab1;

import java.util.Scanner;

public class Lab1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите целое число.");
            scanner.close();
            return;
        }
        int year = scanner.nextInt();
        if (year <= 0) {
            System.out.println("Значение должно быть больше 0.");
            scanner.close();
            return;
        }
        String[] animals = {
                "Крысы", "Коровы", "Тигра", "Зайца",
                "Дракона", "Змеи", "Лошади", "Овцы",
                "Обезьяны", "Курицы", "Собаки", "Свиньи"
        };

        int animal = ((year - 1996) % 12);
        System.out.printf("%dг.- год %s", year, animals[animal]);
    }
}
