package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Good> goods;
    private List<Cashier> cashiers;
    private List<Receipt> receipts; //posle shte ima func za size() of list
    private List<Register> registers;
    private int numOfReceipts;
    private double totalEarningsShop;
    private String name;

    public Shop(String name) {
        this.goods = new ArrayList<>();
        this.cashiers = new ArrayList<>();
        this.receipts = new ArrayList<>();
        this.registers= new ArrayList<>();
        this.numOfReceipts = 0;
        this.totalEarningsShop = 0;
        this.name=name;
    }


    public List<Good> getGoods() {
        return goods;
    }

    public List<Cashier> getCashiers() {
        return cashiers;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public List<Register> getRegisters() {
        return registers;
    }

    public String getName() {
        return name;
    }

    public void addGoods(Good good){
        this.goods.add(good);
    }

    public void addCashiers(Cashier cashier){
        this.cashiers.add(cashier);
    }

    public void addReceipts(Receipt receipt){
        this.receipts.add(receipt);
    }

    public void addRegisters(Register register){
        this.registers.add(register);
    }

    public void showGoods(){
        for(Good good:goods){
            System.out.println(good);
        }
    }

    //check total earnings of shop by getting totals from every register
    public double showTotalEarning(){
        for(Register register:this.registers){
            totalEarningsShop+=register.getTotalEarnings();
        }
        return totalEarningsShop;
    }

    //make restock
    public void restock(Good good,int quantity){
        good.plusQuantity(quantity);
    }

    //check number of receipts in shop
    public int showNumOfReceipts(){
        numOfReceipts=this.receipts.size();
        return numOfReceipts;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                "numOfReceipts=" + numOfReceipts +   //vij tuk posle dali shte se promeni
                ", totalEarningsShop=" + totalEarningsShop + //i tuk ako ne gi mahai
                '}';
    }
}
