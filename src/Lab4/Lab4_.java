package Lab4;

import java.time.LocalDate;

public class Lab4_ {
    public static void main(String[] args) {
        Book bookOne = new Book("Java 8. Полное руководство", "Г.Шлидт");
        Book bookTwo = new Book("Крейцерова соната", "Л. Толстой");
        Reader readerOne = new Reader("Пётр", bookTwo, LocalDate.of(2026, 4, 1));
        Reader readerTwo = new Reader("Вася", bookOne, LocalDate.of(2026, 3, 25));
        System.out.println(Reader.deadline(readerOne, LocalDate.of(2026, 3, 29)));
        System.out.println(Reader.deadline(readerTwo, LocalDate.of(2026, 3, 29)));
        System.out.println(readerOne.toString());
        System.out.println(readerTwo.toString());
        System.out.println(bookOne.toString());
        System.out.println(bookTwo.toString());

    }
}
