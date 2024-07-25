package serializationpractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserStorageTest {

    private final String emptyFilePath = "src/test/resources/emptyFile.txt";
    private final String userFilePath = "src/test/resources/userFile.txt";
    private final User tj = new User(1, "TJ", 25);
    private final User alex = new User(2, "Alex", 25);
    private final User kiki = new User(3, "Kiki", 1);

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

            out.println(tj);
            out.println(alex);
            out.println(kiki);

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
        UserStorage userStorage = new UserStorage(userFilePath);

        //Act
        User user = userStorage.readUser(tj.getId());

        //Assert
        assertEquals(tj, user);
    }

    @Test
    public void test_writeUser_AddOneUserToEmptyFile(){
        //Arrange
        UserStorage userStorage = new UserStorage(emptyFilePath);


        //Act
        userStorage.writeUser(tj);
        User userReadFromFile = userStorage.readUser(tj.getId());

        //Assert
        assertEquals(tj, userReadFromFile);
    }

    @Test
    public void test_readUser_FromFileWithMultipleUsers(){
        //Arrange
        UserStorage userStorage = new UserStorage(userFilePath);

        //Act
        User userReadFromFile = userStorage.readUser(kiki.getId());

        //Assert
        assertEquals(kiki, userReadFromFile);
    }

    @Test
    public void test_writeUser_AddTwoUsersToEmptyFile_verifySecondUser(){
        //Arrange
        UserStorage userStorage = new UserStorage(emptyFilePath);

        //Act
        userStorage.writeUser(tj);
        userStorage.writeUser(alex);
        User userReadFromFile = userStorage.readUser(tj.getId());
        User userReadFromFile1 = userStorage.readUser(alex.getId());

        //Assert
        assertEquals(tj, userReadFromFile);
        assertEquals(alex, userReadFromFile1);
    }

    @Test
    public void test_readAllUsers_allUsersAreReadSuccessfully(){
        //Arrange
        UserStorage userStorage = new UserStorage(userFilePath);
        List<User> expected = Arrays.asList(tj, alex, kiki);

        //Act
        List<User> allUsers = userStorage.readAllUsers();

        //Assert
        assertEquals(expected, allUsers);
    }

    @Test
    public void test_deleteUser_correctlyDeletesUserFromFile(){
        //Arrange
        UserStorage userStorage = new UserStorage(userFilePath);
        List<User> expected = Arrays.asList(alex, kiki);

        //Act
        userStorage.deleteUser(tj.getId());
        List<User> allUsers = userStorage.readAllUsers();

        //Assert
        assertEquals(expected, allUsers);
    }

}
