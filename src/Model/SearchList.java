/*
Sér um að fara gegnum Hotel listann og hendir út þeim hótelum sem passa ekki við leitarskilyrði.
Fallið getAviableHotels() skilar síðan lista af hótelum sem eru laus m.v. leitarskilyrði.
 */
package Model;

import databases.DatabaseConnection;
import java.util.ArrayList;

/**
 *
 * @author Bob
 */
public class SearchList {
    
    public SearchList() {
        
    }
    
    public ArrayList<Hotel> getHotelList(){
        ArrayList<Hotel> listOfSearchHotel = new ArrayList<>();
        listOfSearchHotel = DatabaseConnection.getAllHotel();
        
        // framkcæma einhverja eyðingu úr lista eftir leitarskilyrðum
        
        return listOfSearchHotel;
    }
    
    public ArrayList<Room> getRoomList(ArrayList<Hotel> hotelList) {
        ArrayList<Room> rooms = new ArrayList<>();
        
        // framkvæma leit af herbergjum gegnum DB
        
        return rooms;
    }
    
}
