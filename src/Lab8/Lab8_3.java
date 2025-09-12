package Lab8;

import java.util.Scanner;

public class Lab8_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("[\\s,]+");
        int count = 0;
        for (String word : line) {
            if (word.length() == 3)
                count++;
        }
        System.out.println("Kоличество трехбуквенных слов в предложении: " + count);
        scanner.close();
    }
}
