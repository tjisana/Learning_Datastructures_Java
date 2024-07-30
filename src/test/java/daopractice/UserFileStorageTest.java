package daopractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserFileStorageTest {

    private final String emptyFilePath = "src/test/resources/emptyFile.txt";
    private final String userFilePath = "src/test/resources/userFile.txt";
    private final User tj = new User(1, "TJ", 25);
    private final User alex = new User(2, "Alex", 25);
    private final User kiki = new User(3, "Kiki", 1);

    @BeforeEach
    public void setupFiles() throws IOException {
        try(FileOutputStream fos = new FileOutputStream(emptyFilePath)) {
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
        UserDAO userStorage = new UserFileStorage(emptyFilePath);

        //Act
        User user = userStorage.read(id);

        //Assert
        assertNull(user);
    }

    @Test
    public void test_read_returnsNotNull_whenPassedIDMatchingRecordInFile(){
        //Arrange
        int id = 1;
        UserDAO userStorage = new UserFileStorage(userFilePath);

        //Act
        User user = userStorage.read(id);

        //Assert
        assertNotNull(user);
    }

    @Test
    public void test_readUser_returnsWithCorrectFields_whenPassedIDMatchingRecordInFile(){
        //Arrange
        UserDAO userStorage = new UserFileStorage(userFilePath);

        //Act
        User user = userStorage.read(tj.getId());

        //Assert
        assertEquals(tj, user);
    }

    @Test
    public void test_writeUser_AddOneToEmptyFile(){
        //Arrange
        UserDAO userStorage = new UserFileStorage(emptyFilePath);

        //Act
        userStorage.write(tj);
        User userReadFromFile = userStorage.read(tj.getId());

        //Assert
        assertEquals(tj, userReadFromFile);
    }

    @Test
    public void test_read_FromFileWithMultipleUsers(){
        //Arrange
        UserDAO userStorage = new UserFileStorage(userFilePath);

        //Act
        User userReadFromFile = userStorage.read(kiki.getId());

        //Assert
        assertEquals(kiki, userReadFromFile);
    }

    @Test
    public void test_writeUser_AddTwoUsersToEmptyFile_verifySecond(){
        //Arrange
        UserDAO userStorage = new UserFileStorage(emptyFilePath);

        //Act
        userStorage.write(tj);
        userStorage.write(alex);
        User userReadFromFile = userStorage.read(tj.getId());
        User userReadFromFile1 = userStorage.read(alex.getId());

        //Assert
        assertEquals(tj, userReadFromFile);
        assertEquals(alex, userReadFromFile1);
    }

    @Test
    public void test_readAllUsers_allUsersAreReadSuccessfully(){
        //Arrange
        UserDAO userStorage = new UserFileStorage(userFilePath);
        List<User> expected = Arrays.asList(tj, alex, kiki);

        //Act
        List<User> allUsers = userStorage.readAll();

        //Assert
        assertEquals(expected, allUsers);
    }

    @Test
    public void test_deleteUser_correctlyDeletesFromFile(){
        //Arrange
        UserDAO userStorage = new UserFileStorage(userFilePath);
        List<User> expected = Arrays.asList(alex, kiki);

        //Act
        userStorage.delete(tj.getId());
        List<User> allUsers = userStorage.readAll();

        //Assert
        assertEquals(expected, allUsers);
    }
}
