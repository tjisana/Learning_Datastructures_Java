package daopractice;

import java.io.*;
import java.util.List;

public class UserBinaryFileStorage implements UserDAO{

    private final File file;

    public UserBinaryFileStorage(String filePath){
        this.file = new File(filePath);
    }

    @Override
    public User readUser(int id) {
        try(InputStream in = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(in);){
            User user;

            while ((user =(User) inputStream.readObject()) != null) {
                if (user.getId() == id){
                    return user;
                }
            }
        } catch (NullPointerException e){
            return null;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void writeUser(User user) {
        try(OutputStream out = new FileOutputStream(file, true);
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            )
        {
            outputStream.writeObject(user);

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    @Override
    public List<User> readAllUsers() {
        return List.of();
    }

    @Override
    public void deleteUser(int id) {

    }
}
