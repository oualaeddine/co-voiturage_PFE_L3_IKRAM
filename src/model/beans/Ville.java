package model.beans;

public class Ville {
    private int id;

    private String name;

    public Ville() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
