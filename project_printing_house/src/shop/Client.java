package shop;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private double budget;
    private List<Good> intoCartList;
    private double total;
    //private String name;
    private Register register;

    public Client(double budget,Register register) {
        this.budget = budget;
        this.intoCartList = new ArrayList<>();
        this.total = 0;
        //this.name=name;
        this.register=register;
    }

    public double getBudget() {
        return budget;
    }

    public List<Good> getIntoCartList() {
        return intoCartList;
    }

    public double getTotal() {
        return total;
    }

    /*public String getName() {
        return name;
    } */
    public void displayCartGoods(){
        for(Good good:intoCartList){
            System.out.println(good);
        }
    }

    public void addInCart(Good good,int quantityNeeded) throws InsufficientQuantity {
        this.total+= quantityNeeded * good.getPricePerGood();
        if (good.getQuantity() < quantityNeeded) {
                throw new InsufficientQuantity(Math.abs(good.getQuantity() - quantityNeeded), good);
            }else if(good.getQuantity() >= quantityNeeded && this.getBudget()>=this.total){
            Good goodToAdd = new Good(good.getName(), good.getPricePerGood(), good.getExpirationDate(), quantityNeeded);
            goodToAdd.setId(good.getId());
            intoCartList.add(goodToAdd);
            good.minusQuantity(quantityNeeded); //!!! sync

            }
        }

        public Receipt buy(){
        Receipt receipt = new Receipt(this.register.getCashier());
        if(this.getBudget()<this.total){
            System.out.println();
            System.out.println("Sorry you don't have enough cash.");
            System.out.println();
        }else {
            this.register.setTotalEarnings(total);
            for(Good good:this.intoCartList){
                receipt.addGoodsIntoReceipt(good);
            }
        }
        return receipt;
    }

    @Override
    public String toString() {
        return "Client{" +
                "budget=" + budget +
                ", total=" + total +
                ", name='" +
                ", register=" + register +
                '}';
    }


}
