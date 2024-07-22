import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class UserStorage {

    private final File file;

    public UserStorage(String filePath){
        this.file = new File(filePath);
    }

    public User readUser(int i){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] readlines = bufferedReader.readLine().split(",");

            System.out.println(Arrays.toString(readlines));
            int id = Integer.parseInt(readlines[0]);
            String name = readlines[1];
            int age = Integer.parseInt(readlines[2]);
            User user = new User(id, name, age);
            return user;
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
//                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    public void writeUser(User user){

    }
}
