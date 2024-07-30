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
    private final UserOld tj = new UserOld(1, "TJ", 25);
    private final UserOld alex = new UserOld(2, "Alex", 25);
    private final UserOld kiki = new UserOld(3, "Kiki", 1);

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
        UserOld userOld = userStorage.readUser(id);

        //Assert
        assertNull(userOld);
    }

    @Test
    public void test_readUser_returnsNotNull_whenPassedIDMatchingRecordInFile(){
        //Arrange
        int id = 1;
        UserStorage userStorage = new UserStorage(userFilePath);

        //Act
        UserOld userOld = userStorage.readUser(id);

        //Assert
        assertNotNull(userOld);
    }

    @Test
    public void test_readUser_returnsUserWithCorrectFields_whenPassedIDMatchingRecordInFile(){
        //Arrange
        UserStorage userStorage = new UserStorage(userFilePath);

        //Act
        UserOld userOld = userStorage.readUser(tj.getId());

        //Assert
        assertEquals(tj, userOld);
    }

    @Test
    public void test_writeUser_AddOneUserToEmptyFile(){
        //Arrange
        UserStorage userStorage = new UserStorage(emptyFilePath);


        //Act
        userStorage.writeUser(tj);
        UserOld userOldReadFromFile = userStorage.readUser(tj.getId());

        //Assert
        assertEquals(tj, userOldReadFromFile);
    }

    @Test
    public void test_readUser_FromFileWithMultipleUsers(){
        //Arrange
        UserStorage userStorage = new UserStorage(userFilePath);

        //Act
        UserOld userOldReadFromFile = userStorage.readUser(kiki.getId());

        //Assert
        assertEquals(kiki, userOldReadFromFile);
    }

    @Test
    public void test_writeUser_AddTwoUsersToEmptyFile_verifySecondUser(){
        //Arrange
        UserStorage userStorage = new UserStorage(emptyFilePath);

        //Act
        userStorage.writeUser(tj);
        userStorage.writeUser(alex);
        UserOld userOldReadFromFile = userStorage.readUser(tj.getId());
        UserOld userOldReadFromFile1 = userStorage.readUser(alex.getId());

        //Assert
        assertEquals(tj, userOldReadFromFile);
        assertEquals(alex, userOldReadFromFile1);
    }

    @Test
    public void test_readAllUsers_allUsersAreReadSuccessfully(){
        //Arrange
        UserStorage userStorage = new UserStorage(userFilePath);
        List<UserOld> expected = Arrays.asList(tj, alex, kiki);

        //Act
        List<UserOld> allUserOlds = userStorage.readAllUsers();

        //Assert
        assertEquals(expected, allUserOlds);
    }

    @Test
    public void test_deleteUser_correctlyDeletesUserFromFile(){
        //Arrange
        UserStorage userStorage = new UserStorage(userFilePath);
        List<UserOld> expected = Arrays.asList(alex, kiki);

        //Act
        userStorage.deleteUser(tj.getId());
        List<UserOld> allUserOlds = userStorage.readAllUsers();

        //Assert
        assertEquals(expected, allUserOlds);
    }

}
