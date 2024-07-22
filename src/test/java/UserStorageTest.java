import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserStorageTest {

    @Test
    public void test_EmptyFileReturnNoUsers(){
        //Arrange
        String fileName = "emptyFile.txt";
        int id = 1;
        UserStorage userStorage = new UserStorage(fileName);

        //Act
        User user = userStorage.readUser(id);

        //Assert
        assertNull(user);
    }

    @Test
    public void test_readUser_returnsNotNull_whenPassedIDMatchingRecordInFile(){
        //Arrange
        String fileName = "src/test/resources/fileWith1User.txt";
        int id = 1;
        UserStorage userStorage = new UserStorage(fileName);

        //Act
        User user = userStorage.readUser(id);

        //Assert
        assertNotNull(user);
    }

    @Test
    public void test_readUser_returnsUserWithCorrectFields_whenPassedIDMatchingRecordInFile(){
        //Arrange
        String fileName = "C:\\Users\\tjisa\\dev\\Learning_Datastructures_Java\\src\\test\\resources\\fileWith1User.txt";
        int id = 1;
        String name = "TJ";
        int age = 25;
        UserStorage userStorage = new UserStorage(fileName);
        User expectedUser = new User(id, name, age);

        //Act
        User user = userStorage.readUser(id);

        //Assert
        assertEquals(expectedUser, user);
    }
}
