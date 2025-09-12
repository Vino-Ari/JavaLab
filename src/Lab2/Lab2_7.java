package Lab2;

import java.util.*;

public class Lab2_7 {
    private static ArrayList<String> DECK = new ArrayList<>(List.of(new String[]{"2Ч", "2Б", "2К", "2П", "3Ч", "3Б", "3К", "3П", "4Ч", "4Б", "4К", "4П", "5Ч", "5Б",
            "5К", "5П", "6Ч", "6Б", "6К", "6П", "7Ч", "7Б", "7К", "7П", "8Ч", "8Б", "8К", "8П",
            "9Ч", "9Б", "9К", "9П", "10Ч", "10Б", "10К", "10П", "ВЧ", "ВБ", "ВК", "ВП", "ДЧ", "ДБ",
            "ДК", "ДП", "КЧ", "КБ", "КК", "КП", "ТЧ", "ТБ", "ТК", "ТП"}));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество игроков: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите целое число.");
            scanner.close();
            return;
        }

        int numPlayers = scanner.nextInt();
        scanner.close();
        if (numPlayers <= 0 || numPlayers > 11) {
            System.out.println("Количество игроков должно быть от 1 до 10 включительно.");
            return;
        }

        for (int i = 1; i <= numPlayers; i++) {
            System.out.printf("\nИгрок №%d:\n", i);
            for (int j = 0; j < 5; j++) {
                System.out.print(getCard() + "\t");  //
            }
            System.out.println();
        }
    }


    public static String getCard() {
        Random random = new Random();
        int index = random.nextInt(DECK.size());
        System.out.println(DECK.size());
        String card = DECK.get(index);
        DECK.remove(index);
        return card;
    }
}
