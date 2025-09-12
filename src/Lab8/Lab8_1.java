package Lab8;

import java.util.Scanner;

public class Lab8_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String line = scanner.nextLine();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (!Character.isUpperCase(c)) {
                text.append(c);
            }
        }
        System.out.println("Результат: " + text.toString());
        scanner.close();
    }
}
