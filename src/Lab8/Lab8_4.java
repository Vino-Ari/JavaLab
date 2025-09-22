package Lab8;

import java.util.Scanner;

public class Lab8_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        scanner.close();
        isValidPassword(password);
    }

    private static void isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 12) {
            System.err.println("Длина пароля должна быть от 8 до 12 символов включительно");
            return;
        }
        if (!password.matches(".*[A-Z].*")) {
            System.err.println("Пароль должен содержать минимум одну большую букву");
            return;
        }
        if (!password.matches(".*[a-z].*")) {
            System.err.println("Пароль должен содержать минимум одну маленькую букву");
            return;
        }
        if (!password.matches(".*[@#$%^&*<>.?!,].*")) {
            System.err.println("Пароль должен содержать минимум один специальный символ (@,#,$,%,^,&,*,<,>,'.','?','!',',')");
            return;
        }
        System.out.println("Ваш пароль надежный");
    }
}
