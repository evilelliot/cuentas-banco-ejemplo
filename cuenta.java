import java.util.Random;
import java.io.FileWriter; 
import java.io.IOException;  

public class cuenta {
    // Information
    private int id;
    private int clabe;
    private int pin;
    public String ownerName;
    public String cardype;

    // Money
    private double moneyStock;
    private String currency;
    
    public cuenta(String owner, String cardtype, int pin){
        this.ownerName = owner;
        this.cardype   = cardtype;
        this.pin = pin;
        this.setID();
        this.setCLABE();

        // store account into a file
        this.storeAccount();

        
    }
    // validators
    public boolean validatePIN(int pin){
        if(pin == this.pin){
            return true;
        }else{
            return false;
        }
    }
    // setters
    public void setMStock(double mstock){
        this.moneyStock = mstock;
    }
    public void setCurrency(String currency){
        this.currency = currency;
    }
    private void setID(){
        Random rnd = new Random();
        this.id = 100000 + rnd.nextInt(900000);
    }
    private void setCLABE(){
        Random rnd = new Random();
        this.clabe = 100000 + rnd.nextInt(900000);
    }
    private void storeAccount(){
        String filename = this.ownerName + "_" + this.clabe + ".txt";
        try {
            FileWriter storage = new FileWriter(filename);
            storage.write(this.id + "| " + this.ownerName + "| " + this.clabe + "| ");
            storage.close();
        } catch (IOException e) {
            System.out.println("Ocurrio un error.");
            e.printStackTrace();
        }

    }
    public void setStock(double amount){
        this.moneyStock = moneyStock + amount;
    }
    // getters
    public void getMoney(double amount, int security, boolean message){
        if(security == this.pin){
            if(this.moneyStock >= amount){
                this.moneyStock = this.moneyStock - amount;
                if(message == true){
                    System.out.print("Retiraste: " + amount +  " " +  this.currency);
                }
            }else{
                System.out.print("No posees los fondos suficientes para retirar esa cantidad.");
            }
        }else{
            System.out.print("No estás autorizado a realizar esta acción.");
        }
        
    }
    
    public int getCLABE(){
        return this.clabe;
    }
    public void getInformation(int security){
        if(security == this.pin){
            System.out.print("ID: " + this.id + '\n');
            System.out.print("Cuenta " + this.cardype + " de " + this.ownerName + " en " + this.currency + '\n');
            System.out.print("Saldo " + this.moneyStock + '\n');

        }else{
            System.out.print("No estás autorizado a realizar esta acción.");
        }
    }
}
