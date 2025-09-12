package Lab4;

public class Book {
    private String name;
    private String author;

    public Book() {
        this("Без названия", "Неизвестен");
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(Book book) {
        this(book.name, book.author);
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Название: " + name +
                "\nАвтор: " + author;
    }
}
