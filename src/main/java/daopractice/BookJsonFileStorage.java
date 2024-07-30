package daopractice;

import com.google.gson.Gson;

import java.io.*;
import java.util.List;

public class BookJsonFileStorage implements IDAO<Book>{

    private final File file;

    public BookJsonFileStorage(File file) {
        this.file = file;
    }

    @Override
    public Book read(int id) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file.toPath().toString()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        return gson.fromJson(bufferedReader, Book.class);
    }

    @Override
    public void write(Book book) {
//        Gson gson = new Gson();
//        try {
//            System.out.println(gson.toJson(book));
//            gson.toJson(book, new FileWriter(file.toPath().toString()));
//        } catch (IOException e) {
//            System.out.printf("write method --> %s%n", e.getClass());
//            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
//        }

        Gson gson = new Gson();

        // write to this file
        try (Writer writer = new FileWriter(file.toPath().toString())) {

            // Convert the Java object `person` into a JSON data and write to a file
            gson.toJson(book, writer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> readAll() {
        return List.of();
    }

    @Override
    public void delete(int id) {

    }
}
