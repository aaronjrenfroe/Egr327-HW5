package HW5;

import HW1.Inventory;
import HW1.Vehicle;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.SerializationUtils;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by AaronR on 10/2/17.
 * for ?
 */
public class Dealer implements java.io.Serializable {
    private static final String URL_SOURCE = "https://raw.githubusercontent.com/kyungsooim/TestData/master/data/SeptemberInventory.txt";

    Inventory inventory;

    public Dealer() {
        inventory = new Inventory();

        URL source = getUrlQuietly(URL_SOURCE);
        String data = getStringFromURLQuietly(source);
        parseDataToInventory(data);

    }

    public static byte[] serialize(Dealer d){
        return SerializationUtils.serialize(d);
    }

    public static Dealer deserialize(byte[] data){
        return SerializationUtils.deserialize(data);

    }

    // Helpers

    private Vehicle parseVehicle(String data){
        String[] vals = data.split(",");
        String[] mm = vals[0].split(" ");
        boolean is4x4 = false;
        try{
            is4x4 = Boolean.parseBoolean(vals[3]);

        }catch (IndexOutOfBoundsException ioobe){

        }

        return new Vehicle(mm[0], mm[1],vals[1], Double.parseDouble(vals[2]), "0", is4x4);
    }

    private void parseDataToInventory(String data){
        String[] lines = data.split("\n");
        for (int i = 0; i < lines.length; i++) {
            inventory.add(parseVehicle(lines[i]));
        }
    }
    private URL getUrlQuietly(String strSrc){
        try{
            URL source = new URL(strSrc);
            return source;
        }catch (MalformedURLException mue){
            return null;
        }
    }

    private String getStringFromURLQuietly(URL url){
        try{
            return IOUtils.toString(url, "UTF-8");
        }catch (IOException ioe){
            return null;
        }
    }

}
