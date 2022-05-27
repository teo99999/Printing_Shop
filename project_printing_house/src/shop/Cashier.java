package shop;

public class Cashier {
    private int id;
    private static int num=0;
    private String name;

    public Cashier(String name) {
        this.name = name;
        num++;
        id=num;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
