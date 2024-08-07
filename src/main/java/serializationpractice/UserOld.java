package serializationpractice;

import java.util.Objects;

public class UserOld {
    private int id;
    private String name;
    private int age;

    public UserOld(){}

    public UserOld(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return String.format("%s,%s,%s", this.id, this.name, this.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOld userOld = (UserOld) o;
        return id == userOld.id && age == userOld.age && Objects.equals(name, userOld.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
