import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import serializationpractice.User;
import serializationpractice.UserStorage;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserStorageTest {

    private final String emptyFilePath = "src/test/resources/emptyFile.txt";
    private final String userFilePath = "src/test/resources/userFile.txt";

    @BeforeEach
    public void setupFiles() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(emptyFilePath)) {
            // File will be created or overwritten
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try(FileWriter fw = new FileWriter(userFilePath, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {

            out.println("1,TJ,25");
            out.println("2,Alex,25");
            out.println("3,Kiki,1");

        } catch (IOException e) {
            System.out.printf("Could not create setup file %s%n",userFilePath);
        }

    }

    @Test
    public void test_EmptyFileReturnNoUsers(){
        //Arrange
        int id = 1;
        UserStorage userStorage = new UserStorage(emptyFilePath);

        //Act
        User user = userStorage.readUser(id);

        //Assert
        assertNull(user);
    }

    @Test
    public void test_readUser_returnsNotNull_whenPassedIDMatchingRecordInFile(){
        //Arrange
        int id = 1;
        UserStorage userStorage = new UserStorage(userFilePath);

        //Act
        User user = userStorage.readUser(id);

        //Assert
        assertNotNull(user);
    }

    @Test
    public void test_readUser_returnsUserWithCorrectFields_whenPassedIDMatchingRecordInFile(){
        //Arrange
        int id = 1;
        String name = "TJ";
        int age = 25;
        UserStorage userStorage = new UserStorage(userFilePath);
        User expectedUser = new User(id, name, age);

        //Act
        User user = userStorage.readUser(id);

        //Assert
        assertEquals(expectedUser, user);
    }

    @Test
    public void test_writeUser_AddOneUserToEmptyFile(){
        //Arrange
        int id = 1;
        String name = "TJ";
        int age = 25;
        UserStorage userStorage = new UserStorage(emptyFilePath);
        User userToBeWritten = new User(id, name, age);

        //Act
        userStorage.writeUser(userToBeWritten);
        User userReadFromFile = userStorage.readUser(id);

        //Assert
        assertEquals(userToBeWritten, userReadFromFile);
    }

    @Test
    public void test_readUser_FromFileWithMultipleUsers(){
        //Arrange
        UserStorage userStorage = new UserStorage(userFilePath);
        int expectedId = 3;
        User expectedUser = new User(expectedId, "Kiki", 1);

        //Act
        User userReadFromFile = userStorage.readUser(expectedId);

        //Assert
        assertEquals(expectedUser, userReadFromFile);
    }

    @Test
    public void test_writeUser_AddTwoUsersToEmptyFile_verifySecondUser(){
        //Arrange
        UserStorage userStorage = new UserStorage(emptyFilePath);
        int expectedId = 1;
        User userToBeWritten = new User(expectedId, "TJ", 25);
        int expectedId1 = 2;
        User userToBeWritten1 = new User(expectedId1, "Alex", 25);

        //Act
        userStorage.writeUser(userToBeWritten);
        userStorage.writeUser(userToBeWritten1);
        User userReadFromFile = userStorage.readUser(expectedId);
        User userReadFromFile1 = userStorage.readUser(expectedId1);

        //Assert
        assertEquals(userToBeWritten, userReadFromFile);
        assertEquals(userToBeWritten1, userReadFromFile1);
    }

    @Test
    public void test_readAllUsers_allUsersAreReadSuccessfully(){
        //Arrange
        UserStorage userStorage = new UserStorage(userFilePath);
        User tj = new User(1, "TJ", 25);
        User alex = new User(1, "Alex", 25);
        User kiki = new User(1, "Kiki", 1);

        //Act
        List<User> allUsers = userStorage.readAllUsers();

        //Assert

    }

}
