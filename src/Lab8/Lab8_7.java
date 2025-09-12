package Lab8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lab8_7 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ivann\\IdeaProjects\\JavaLab\\src\\Lab8\\Lab8_6.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден.");
            return;
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }
        int price = 0;
        text.replace(0, text.length(), text.toString().replace(",", " zpt "));
        String[] words = text.toString().split(" ");
        for (String word : words) {
            if (word.length() <= 2) continue;
            price += 10;
            System.out.print(word + " ");
        }
        System.out.printf("Стоимость телеграммы составляет: %dр", price);
    }
}
