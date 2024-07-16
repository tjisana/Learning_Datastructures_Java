import java.lang.reflect.Array;

public class ArrayListTJ <T> {
    private int size;
    private final int initialSize;
    private T[] data;

    ArrayListTJ() {
        initialSize = 10;
        data = (T[]) new Object[initialSize];
    }

    ArrayListTJ(int size) {
        initialSize = size;
        data = (T[]) new Object[size];
    }

    ArrayListTJ(int size, T[] data) {
        initialSize = size;
        this.size = size;
        this.data = data;
    }

    public int getInitialSize(){
        return initialSize;
    }

    public int getSize(){
        return size;
    }

    public int getCurrentCapacity(){
        return data.length;
    }

    public void add(T i){
        if(size == data.length){
            T[] newData = (T[]) new Object[size * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
        data[size] = i;
        size++;
    }

    public T get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }
}
