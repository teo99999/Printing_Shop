package shop;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Receipt {
    private static int num;
    private int id;
    private Cashier cashier;
    private String dateTime;
    private List<Good> goodsSold;
    private double totalValue;

    public Receipt(Cashier cashier){
        this.cashier = cashier;
        Date date = new Date();
        this.dateTime = String.format("Current Date/Time : %tc", date );
        this.totalValue=0;
        this.goodsSold = new ArrayList<>();
        num++;
        id=num;

    }

    public static int getNum() {
        return num;
    }

    public int getId() {
        return id;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public String getDateTime() {
        return dateTime;
    }

    public List<Good> getGoodsSold() {
        return goodsSold;
    }

    public void addGoodsIntoReceipt(Good good){
        this.goodsSold.add(good);
    }


    public void writeToReceipt(){
        File file=new File("files");
        file.mkdir();
        try(FileWriter fileWriter=new FileWriter(file.getName()+"/Receipts "+this.id+".txt")){
            fileWriter.write("Receipt "+this.id+System.lineSeparator());
            fileWriter.write("Cashier "+this.cashier+System.lineSeparator());
            fileWriter.write(this.dateTime+System.lineSeparator());
            fileWriter.write("Products:"+System.lineSeparator());
            for(Good good:this.goodsSold){
                fileWriter.write(good.getName()+"* price: "+good.getPricePerGood()+" quantity: "+good.getQuantity()+System.lineSeparator());
                totalValue+=good.getQuantity()*good.getPricePerGood();
            }

            fileWriter.write("Total: "+this.totalValue+System.lineSeparator());
            fileWriter.write("Thank you for shopping with us :)");

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public List<String> readFromReceipt(String fileName){
        List<String> readReceipt=new ArrayList<>();
        try(FileReader fileReader=new FileReader(fileName)){
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while((line=bufferedReader.readLine())!=null){
                readReceipt.add(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return readReceipt;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", cashier=" + cashier +
                ", dateTime=" + dateTime +
                ", totalValue=" + totalValue +
                '}';
    }
}
