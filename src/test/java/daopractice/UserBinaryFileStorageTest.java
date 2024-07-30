package daopractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserBinaryFileStorageTest {
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

        try(FileOutputStream  fos = new FileOutputStream(userFilePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(tj);
            oos.writeObject(alex);
            oos.writeObject(kiki);

        } catch (IOException e) {
            System.out.printf("Could not create setup file %s%n",userFilePath);
        }

    }

    @Test
    public void test_EmptyFileReturnNoUsers(){
        //Arrange
        int id = 1;
        UserDAO userBinaryFileStorage = new UserBinaryFileStorage(emptyFilePath);

        //Act
        User user = userBinaryFileStorage.read(id);

        //Assert
        assertNull(user);
    }

    @Test
    public void test_read_returnsNotNull_whenPassedIDMatchingRecordInFile(){
        //Arrange
        int id = 1;
        UserDAO userBinaryFileStorage = new UserBinaryFileStorage(userFilePath);

        //Act
        User user = userBinaryFileStorage.read(id);

        //Assert
        assertNotNull(user);
    }

    @Test
    public void test_readUser_returnsUserWithCorrectFields_whenPassedIDMatchingRecordInFile(){
        //Arrange
        UserDAO userBinaryFileStorage = new UserBinaryFileStorage(userFilePath);

        //Act
        User user = userBinaryFileStorage.read(tj.getId());

        //Assert
        assertEquals(tj, user);
    }
//
    @Test
    public void test_writeUser_AddOneToEmptyFile(){
        //Arrange
        UserDAO userBinaryFileStorage = new UserBinaryFileStorage(emptyFilePath);

        //Act
        userBinaryFileStorage.write(tj);
        User userReadFromFile = userBinaryFileStorage.read(tj.getId());

        //Assert
        assertEquals(tj, userReadFromFile);
    }

    @Test
    public void test_readUser_FromFileWithMultipleUsers(){
        //Arrange
        UserDAO userBinaryFileStorage = new UserBinaryFileStorage(userFilePath);

        //Act
        User userReadFromFile = userBinaryFileStorage.read(kiki.getId());

        //Assert
        assertEquals(kiki, userReadFromFile);
    }

    @Test
    public void test_writeUser_AddTwoUsersToEmptyFile_verifySecondUser(){
        //Arrange
        UserDAO userBinaryFileStorage = new UserBinaryFileStorage(emptyFilePath);

        //Act
        userBinaryFileStorage.write(tj);
        userBinaryFileStorage.write(alex);
        User userReadFromFile = userBinaryFileStorage.read(tj.getId());
        User userReadFromFile1 = userBinaryFileStorage.read(alex.getId());

        //Assert
        assertEquals(tj, userReadFromFile);
        assertEquals(alex, userReadFromFile1);
    }

    @Test
    public void test_readAllUsers_allUsersAreReadSuccessfully(){
        //Arrange
        UserDAO userBinaryFileStorage = new UserBinaryFileStorage(userFilePath);
        List<User> expected = Arrays.asList(tj, alex, kiki);

        //Act
        List<User> allUsers = userBinaryFileStorage.readAll();

        //Assert
        assertEquals(expected, allUsers);
    }

    @Test
    public void test_deleteUser_correctlyDeletesUserFromFile(){
        //Arrange
        UserDAO userStorage = new UserBinaryFileStorage(userFilePath);
        List<User> expected = Arrays.asList(alex, kiki);

        //Act
        userStorage.delete(tj.getId());
        List<User> allUsers = userStorage.readAll();

        //Assert
        assertEquals(expected, allUsers);
    }

    @Test
    public void test_writeUser_customSerializationIsCorrect(){
        //Arrange
        int level = 50;
        int expectedLevel = 100;
        UserDAO userBinaryFileStorage = new UserBinaryFileStorage(emptyFilePath);
        User thanos = new User(4, "Thanos", 1000, level);

        //Act
        userBinaryFileStorage.write(thanos);
        User userReadFromFile = userBinaryFileStorage.read(thanos.getId());


        //Assert
        assertEquals(expectedLevel, userReadFromFile.getLevel());
    }
}
