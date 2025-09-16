package Lab4;

import java.time.LocalDate;

public class Reader {
    private String name;
    private Book book;
    private LocalDate date;

    public Reader(String name) {
        this.name = name;
    }

    public Reader(String name, Book book, LocalDate date) {
        this.name = name;
        this.book = book;
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDate() {
        return date;
    }

    public static boolean deadline(Reader reader, LocalDate date) {
        return date.isAfter(reader.getDate()) || date.isEqual(reader.getDate());
    }

    @Override
    public String toString() {
        return "Имя: " + name +
                "\nКнгига: " + book.getName() +
                "\nАвтор: " + book.getAuthor() +
                "\nCдать до: " + date.toString();
    }
}
