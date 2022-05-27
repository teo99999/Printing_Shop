package shop;

public class InsufficientQuantity extends Exception {
    private int quantityNotEnough;
    private Good good;

    public InsufficientQuantity(int currentQuantity, Good good) {
        this.quantityNotEnough = currentQuantity;
        this.good = good;
    }

    public int getQuantityNotEnough() {
        return quantityNotEnough;
    }

    public Good getGood() {
        return good;
    }

    @Override
    public String toString() {
        return "InsufficientQuantity{" +
                "quantity needed=" + quantityNotEnough +
                ", of good " + good +
                '}';
    }
}
