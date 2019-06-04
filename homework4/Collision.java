package homework4;

import java.util.Objects;

public class Collision {
    private int id;
    private String name;

    public Collision(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "|id: " + id + " name: " + name + "|";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collision catCollision = (Collision) o;
        return id == catCollision.id &&
                Objects.equals(name, catCollision.name);
    }

    @Override
    public int hashCode() {

        return 1;
    }
}