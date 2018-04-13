/*
Sér um að fara gegnum Hotel listann og hendir út þeim hótelum sem passa ekki við leitarskilyrði.
Fallið getAviableHotels() skilar síðan lista af hótelum sem eru laus m.v. leitarskilyrði.
 */
package Model;

import databases.DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Bob
 */
public class SearchList {
    
    public SearchList() {
        
    }
        private static Connection getConnection() {
        Connection con = null;
        try {
            
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:hotelDatabase.db");
        } catch(Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return con;
    }
    
    
    public static ArrayList<Hotel> getHotel(String query) {
        ArrayList<Hotel> hotelList = new ArrayList<>();
        Connection c = null;
        try {
            c = getConnection();
            //String stmt = "SELECT userName FROM Users WHERE userName = " + username + " AND password = " + passwordHash;
            PreparedStatement p = c.prepareStatement(query);
            ResultSet rs = p.executeQuery();
            //String un = r.getString(1);
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String hotelName = rs.getString("nameOfHotel");
                        System.out.println(hotelName + " hotelname inní rs.next");
                String location = rs.getString("location");
                boolean aviableForHandic = rs.getBoolean("aviableForHandic");
                boolean gym = rs.getBoolean("gym");
                boolean swimmingPool = rs.getBoolean("swimmingPool");
                boolean wifi = rs.getBoolean("wifi");
                boolean pickUp = rs.getBoolean("pickUp");
                boolean breakfastIncluded = rs.getBoolean("breakfastIncluded");
                
                Hotel hotel = null;
                hotel = new Hotel(hotelName, location, aviableForHandic,gym, swimmingPool, wifi, pickUp, breakfastIncluded);
                setRooms(hotelName, hotel);
                hotelList.add(hotel);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("SELECT ERROR(getHotel): " + e.getMessage());
        }
        return hotelList;
    }
    
        public static void setRooms(String hotelName, Hotel hotel){
        //ArrayList<Room> roomList = new ArrayList<>();
        Connection c = null;
        try {
            c = getConnection();
            //String stmt = "SELECT userName FROM Users WHERE userName = " + username + " AND password = " + passwordHash;
            PreparedStatement p = c.prepareStatement("SELECT * FROM Room WHERE HotelName = '"+ hotelName + "';");
            ResultSet rs = p.executeQuery();
            //String un = r.getString(1);
            while ( rs.next() ) {
                int id = rs.getInt("id");
                int price = rs.getInt("Price");
                int grownUp = rs.getInt("GrownUp");
                int child = rs.getInt("Children");
                
                //Hotel hotel = null;
                //hotel = new Hotel(hotelName, location, aviableForHandic,gym, swimmingPool, wifi, pickUp, breakfastIncluded);
                ArrayList<LocalDate> isBooked = new ArrayList<>();
                hotel.addRoom(price, grownUp, child, isBooked);
                //roomList.add(room);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("SELECT ERROR(setRooms): " + e.getMessage());
        }
    }
        
        
    
/*    public ArrayList<Hotel> getHotelList(String query){
        ArrayList<Hotel> listOfSearchHotel = getHotel(query);
        
        // framkcæma einhverja eyðingu úr lista eftir leitarskilyrðum
        
        return listOfSearchHotel;
    }
  */  
    public ArrayList<Room> getRoomList(ArrayList<Hotel> hotelList) {
        ArrayList<Room> rooms = new ArrayList<>();
        
        // framkvæma leit af herbergjum gegnum DB
        
        return rooms;
    }
    
}
