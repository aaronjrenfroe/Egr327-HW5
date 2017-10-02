package HW5;

import HW1.Inventory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AaronR on 10/2/17.
 * for ?
 */
public class DealerTest {
    static Dealer dealer;

    @BeforeClass
    public static void setup(){
        dealer = new Dealer();

    }

    @Test
    public void testData(){

        Inventory inventory = dealer.inventory;

        Assert.assertTrue(dealer.inventory.findCheapestVehicle() != null);
        Assert.assertTrue(dealer.inventory.findMostExpensiveVehicle() != null);

    }

    @Test
    public void serialization() throws Exception {
        byte[] data = Dealer.serialize(dealer);
        Dealer newDealer = Dealer.deserialize(data);
        Assert.assertTrue(dealer.inventory.findCheapestVehicle() != null);
        Assert.assertTrue(dealer.inventory.findMostExpensiveVehicle() != null);

    }



}