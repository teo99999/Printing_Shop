package shop;

public class Register implements Runnable {
    private Cashier cashier;
    private double totalEarnings; //ot client shte idvat
    private static int num=0;
    private int id;

    public Register(Cashier cashier) {
        this.cashier = cashier;
        this.totalEarnings = 0;
        num++;
        id=num;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings += totalEarnings;
    }

    public Cashier getCashier() {
        return cashier;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= num; i++) {
                System.out.println("Register " + id + " " + Thread.currentThread().getName() + " is working with cashier - " + cashier + ".");
            }
            Thread.sleep(5000); //napravi go po-malko!!!
            System.out.println(Thread.currentThread().getName() + " has finished.");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
