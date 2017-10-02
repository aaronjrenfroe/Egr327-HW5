package HW5;

/**
 * Created by AaronR on 10/2/17.
 * for ?
 */
public class UseDealer {
    public static void main(String[] args) {
        Dealer d = new Dealer();
        byte[] data = Dealer.serialize(d);
        Dealer d2 = Dealer.deserialize(data);
        System.out.println(d2.inventory.findMostExpensiveVehicle().getMake() + " " + d2.inventory.findMostExpensiveVehicle().getModel());
    }
}
