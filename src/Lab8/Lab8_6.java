package Lab8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Lab8_6 {
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
        String[] sentences = text.toString().split("[.?!]");
        System.out.println("Введите ключевое слово:");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        scanner.close();
        boolean foundAnySentence = false;
        for (String sentence : sentences) {
            if (sentence.isEmpty()) {
                continue;
            }
            if (sentence.matches(".*(?i)\\b" + Pattern.quote(word) + "\\b.*")) {
                System.out.println(sentence);
                foundAnySentence = true;
            }
        }
        if (!foundAnySentence) {
            System.out.println("Ни одно предложение не содержит указанное ключевое слово.");
        }
    }
}
