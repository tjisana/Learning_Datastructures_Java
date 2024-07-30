package daopractice;

import java.util.List;

public interface UserDAO extends IDAO<User> {

    public User read(int id);
    public void write(User user);
    public List<User> readAll();
    public void delete(int id);

}
