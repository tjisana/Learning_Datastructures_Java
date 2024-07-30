package daopractice;

import java.util.List;

public interface IDAO<T> {
    public T read(int id);
    public void write(T t);
    public List<T> readAll();
    public void delete(int id);
}
