package serializationpractice;

import java.io.*;
import java.util.Arrays;

public class UserStorage {

    private final File file;

    public UserStorage(String filePath){
        this.file = new File(filePath);
    }

    public User readUser(int userId){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                int foundId = Integer.parseInt(values[0]);
                if (foundId == userId){
                    return new User(
                            foundId,
                            values[1],
                            Integer.parseInt(values[2])
                    );
                }
            }
        } catch (NullPointerException e){
            return null;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
//            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public User readUser_old(int i){
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
        } catch (NullPointerException e){
            return null;
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
        try(FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(user);

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}
