import shop.*;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

       Shop bila=new Shop("Bila");

        Good tomato = new Good("Tomato", 2.50, "20/06/20", 10);
        Good milk = new Good("Milk", 1.50, "30/06/20", 5);
        Good chocolate = new Good("Chocolate", 2.30, "22/08/20", 15);

        Cashier maria = new Cashier("Maria");
        Cashier stoilka = new Cashier("Stoilka");
        Cashier pesho = new Cashier("Pesho");

        Register register1 = new Register(maria);
        Register register2 = new Register(stoilka);
        Register register3 = new Register(pesho);

        bila.addGoods(tomato);
        bila.addGoods(milk);
        bila.addGoods(chocolate);

        bila.addCashiers(maria);
        bila.addCashiers(stoilka);
        bila.addCashiers(pesho);

        bila.addRegisters(register1);
        bila.addRegisters(register2);
        bila.addRegisters(register3);

        Client client=new Client(50,register1);

        //ima showGoods za 4

       //ot vuvedete vasheto ime i budjet posle se suzdava client s tezi argumenti

        //za exit prosto sout exit i goSwitch=false???

        //napravi izchakvaneto v runa na registerite da e po-malko

        int userChoice;
        boolean goSwitch=true;
        Scanner scanner=new Scanner(System.in);

        while(goSwitch){
            System.out.println("\nChoose a service!\n" + "1.Information for working registers\n" + "2.Display shop products\n"
                    + "3.Restock products\n" + "4.Add products to cart\n"
            + "5.Buy products and get receipt\n" + "6.Exit");
            userChoice=scanner.nextInt();

            label:
            switch (userChoice){
                case 1:
                    Thread th1=new Thread(register1,"reg1");
                    Thread th2=new Thread(register2,"reg2");
                    Thread th3=new Thread(register3,"reg3");

                    th1.start();
                    th2.start();
                    th3.start();
                    break;
                case 2:
                    bila.showGoods();
                    break;
                case 3:
                    System.out.println("Please enter quantity you'd like to restock: ");
                    int quantity;
                    while((quantity=scanner.nextInt())<=0){
                        System.out.println("Enter a positive number: ");
                    }
                    System.out.println("Please enter a product you'd like to restock: ");
                    String productName= scanner.nextLine();
                    switch ((productName = scanner.nextLine())) {
                        case "tomato":
                            bila.restock(tomato, quantity);
                            System.out.println("Current quantity of " + productName + " is " + tomato.getQuantity());
                            break label;
                        case "chocolate":
                            bila.restock(chocolate, quantity);
                            System.out.println("Current quantity of " + productName + " is " + chocolate.getQuantity());
                            break label;
                        case "milk":
                            bila.restock(milk, quantity);
                            System.out.println("Current quantity of " + productName + " is " + milk.getQuantity());
                            break label;
                    }
                case 4:
                    //add products to cart
                    System.out.println("Please enter quantity to add into cart:");
                    int quantityToAdd;
                    while((quantityToAdd=scanner.nextInt())<=0){
                        System.out.println("Enter a positive number:");
                    }
                    System.out.println("Enter a product to add into cart:");
                    String productToAdd=scanner.nextLine();
                    switch (productToAdd=scanner.nextLine()){
                        case "tomato":
                            try {
                                client.addInCart(tomato, quantityToAdd); //tuk try
                                System.out.println("Your cart:");
                                client.displayCartGoods();
                            }catch (InsufficientQuantity e){
                                e.printStackTrace();
                            }
                            break label;
                        case "milk":
                            try{
                                client.addInCart(milk,quantityToAdd);
                                System.out.println("Your cart:");
                                client.displayCartGoods();
                            }catch(InsufficientQuantity e){
                                e.printStackTrace();
                            }
                            break label;
                        case "chocolate":
                            try{
                                client.addInCart(chocolate,quantityToAdd);
                                System.out.println("Your cart:");
                                client.displayCartGoods();
                            }catch(InsufficientQuantity e){
                                e.printStackTrace();
                            }
                            break label;
                    }
                    break;
                case 5:
                    Receipt receipt=client.buy();
                    receipt.writeToReceipt();
                    List<String> receiptContent=receipt.readFromReceipt("files/Receipts 1.txt");

                    System.out.println("*****************************************");
                    for(String line:receiptContent){
                        System.out.println(line);
                    }
                    System.out.println("*****************************************");
                    break;
                case 6:
                    System.out.println("Goodbye :)");
                    goSwitch=false;



            }


        }



    }
}

