package daopractice;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class UserBinaryFileStorage implements UserDAO{

    private final File file;

    public UserBinaryFileStorage(String filePath){
        this.file = new File(filePath);
    }

    @Override
    public User read(int id) {
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
            System.out.println(e.getMessage());
            return null;
//            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void write(User user) {
        List<User> allUsersCurrentlyInFile = readAll();
        if (allUsersCurrentlyInFile == null){
            allUsersCurrentlyInFile = new ArrayList<>();
        }
        try(OutputStream out = Files.newOutputStream(file.toPath());
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            )
        {
            allUsersCurrentlyInFile.add(user);
            for(User user_: allUsersCurrentlyInFile){
                outputStream.writeObject(user_);
            }
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    @Override
    public List<User> readAll() {
        List<User> allUsers = new ArrayList<>();
//        try(InputStream in = new FileInputStream(file);
        try(InputStream in = Files.newInputStream(file.toPath());
            ObjectInputStream inputStream = new ObjectInputStream(in);){
            User user;
            while ((user =(User) inputStream.readObject()) != null) {
                allUsers.add(user);
            }
        } catch (NullPointerException e){
            return null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return allUsers;
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return allUsers;
    }

    @Override
    public void delete(int id) {

    }
}
