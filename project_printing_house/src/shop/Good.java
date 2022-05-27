package shop;


public class Good {
    private int id;
    private static int num=0;
    private String name;
    private double pricePerGood;
    private String expirationDate;
    private int quantity;

    public Good(String name, double pricePerGood, String expirationDate,int quantity) {
        num++;
        this.id = num;
        this.name = name;
        this.pricePerGood = pricePerGood;
        this.expirationDate = expirationDate;
        this.quantity=quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void plusQuantity(int quantity) {
        this.quantity += quantity; //za da natrupvame ///ima plus
    }

    public void minusQuantity(int quantity) {
        this.quantity -= quantity;
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

    public double getPricePerGood() {
        return pricePerGood;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pricePerGood=" + pricePerGood +
                ", expirationDate='" + expirationDate + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
