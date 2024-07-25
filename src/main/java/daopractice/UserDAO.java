package daopractice;

import java.util.List;

public interface UserDAO {

    public User readUser(int id);
    public void writeUser(User user);
    public List<User> readAllUsers();
    public void deleteUser(int id);

}
