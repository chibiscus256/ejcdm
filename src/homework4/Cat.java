package homework4;

import java.util.Objects;

public class Cat {

    private int id;
    private String name;

    public Cat(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return "|id: " + id + " name: " + name + "|";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id == cat.id &&
                Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}


