package Lab8;

import java.util.Scanner;

public class Lab8_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        StringBuilder text = new StringBuilder(scanner.nextLine());
        System.out.println(text.reverse().toString());
        scanner.close();
    }
}
