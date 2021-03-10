import cuenta;
public class banco {
    public static void main(String[] args) {
        // Alberto
        cuenta alberto = new cuenta("Alberto", "Debito", 131415);

        alberto.setMStock(30000);
        alberto.setCurrency("MXN");


        // Montserrat
        cuenta montserrat = new cuenta("Alberto", "Debito", 111111);

        montserrat.setMStock(40000);
        montserrat.setCurrency("MXN");

        transfer(alberto, montserrat, 131415, 200);
        transfer(montserrat, alberto, 111111, 600.33);


        alberto.getInformation(131415);
        montserrat.getInformation(111111);

    }
    public static void transfer(cuenta emisora, cuenta receptora, int cePIN, double amount){
        // emisora.getInformation(cePIN);
        // System.out.print(cePIN);
        
        if(emisora.validatePIN(cePIN) == true){
            emisora.getMoney(amount, cePIN, false);
            receptora.setStock(amount);
            System.out.print("Depositaste " + amount + " a la cuenta: " + receptora.getCLABE() + '\n');
        }else{
            System.out.print("No tienes permisos de realizar esta acción." + '\n');
        }
        
    }
}
