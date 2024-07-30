package daopractice;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private final long isbn;
    private final String name;
    private final int totalPages;
    private final BookType bookType;

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", name='" + name + '\'' +
                ", totalPages=" + totalPages +
                ", bookType=" + bookType +
                '}';
    }

    public Book(long isbn, String name, int totalPages, BookType bookType) {
        this.isbn = isbn;
        this.name = name;
        this.totalPages = totalPages;
        this.bookType = bookType;
    }

    enum BookType {
        HARDCOVER,
        SOFTCOVER,
        KINDLEONLY
    }

    public long getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public BookType getBookType() {
        return bookType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn == book.isbn && totalPages == book.totalPages && Objects.equals(name, book.name) && bookType == book.bookType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, name, totalPages, bookType);
    }
}

