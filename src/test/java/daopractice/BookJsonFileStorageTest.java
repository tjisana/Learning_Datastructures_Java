package daopractice;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookJsonFileStorageTest {
    @Test
    public void test_write_OneBookToEmptyFile(){
        //Arrange
        int isbnBB = 1;
        Book batmanBegins = new Book(isbnBB, "Batman Begins", 100, Book.BookType.HARDCOVER);
        BookJsonFileStorage bookJsonFileStorage = new BookJsonFileStorage(new File("src/test/resources/emptyFile.txt"));

        //Act
        bookJsonFileStorage.write(batmanBegins);
        Book bookReadFromFile = bookJsonFileStorage.read(isbnBB);

        //Assert
        assertEquals(batmanBegins, bookReadFromFile);
    }
}
