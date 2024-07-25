package daopractice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileStorage implements UserDAO{

    private final File file;

    public UserFileStorage(String filePath){
        this.file = new File(filePath);
    }

    @Override
    public User readUser(int id) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                int foundId = Integer.parseInt(values[0]);
                if (foundId == id){
                    return new User(
                            foundId,
                            values[1],
                            Integer.parseInt(values[2]));
                }
            }
        } catch (NullPointerException e){
            return null;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void writeUser(User user) {
        try(FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(user);

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    @Override
    public List<User> readAllUsers() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            List<User> foundUsers = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                foundUsers.add(
                        new User(
                                Integer.parseInt(values[0]),
                                values[1],
                                Integer.parseInt(values[2])
                        )
                );
            }
            return foundUsers;
        } catch (NullPointerException e){
            return null;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(int id) {
        List<User> allusers  = readAllUsers();
        User userToDelete = null;
        for (User user: allusers){
            if (user.getId() == id){
                userToDelete = user;
            }
        }
        allusers.remove(userToDelete);
        file.delete();
        try {
            file.createNewFile();
            for (User user: allusers){
                writeUser(user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
