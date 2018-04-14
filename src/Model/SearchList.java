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
        
    
    public static ArrayList<Hotel> getAllHotel(){
        ArrayList<Hotel> hotelList = new ArrayList<>();
        Connection c = null;
        try {
            c = getConnection();
            //String stmt = "SELECT userName FROM Users WHERE userName = " + username + " AND password = " + passwordHash;
            PreparedStatement p = c.prepareStatement("SELECT * FROM Hotel");
            ResultSet rs = p.executeQuery();
            //String un = r.getString(1);
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String hotelName = rs.getString("nameOfHotel");
                System.out.println("Hotel : " + hotelName);
                String location = rs.getString("location");
                boolean aviableForHandic = rs.getBoolean("aviableForHandic");
                boolean gym = rs.getBoolean("gym");
                boolean swimmingPool = rs.getBoolean("swimmingPool");
                boolean wifi = rs.getBoolean("wifi");
                boolean pickUp = rs.getBoolean("pickUp");
                boolean breakfastIncluded = rs.getBoolean("breakfastIncluded");
                
                Hotel hotel = null;
                hotel = new Hotel(hotelName, location, aviableForHandic,gym, swimmingPool, wifi, pickUp, breakfastIncluded);
                setRooms(hotelName, hotel, "", "", "0", "30000", "", "");
                hotelList.add(hotel);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("SELECT ERROR(getHotel): " + e.getMessage());
        }
        return hotelList;
    }
    
    
    public static ArrayList<Hotel> getHotel(String query, String dateFrom, String dateTo, String priceFrom, String priceTo, String grownUp, String children) {
        ArrayList<Hotel> hotelList = new ArrayList<>();
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement p = c.prepareStatement(query);
            ResultSet rs = p.executeQuery();
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String hotelName = rs.getString("nameOfHotel");
                String location = rs.getString("location");
                boolean aviableForHandic = rs.getBoolean("aviableForHandic");
                boolean gym = rs.getBoolean("gym");
                boolean swimmingPool = rs.getBoolean("swimmingPool");
                boolean wifi = rs.getBoolean("wifi");
                boolean pickUp = rs.getBoolean("pickUp");
                boolean breakfastIncluded = rs.getBoolean("breakfastIncluded");
                
                Hotel hotel = null;
                hotel = new Hotel(hotelName, location, aviableForHandic,gym, swimmingPool, wifi, pickUp, breakfastIncluded);
                setRooms(hotelName, hotel, dateFrom, dateTo, priceFrom, priceTo, grownUp, children);
                hotelList.add(hotel);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("SELECT ERROR(getHotel): " + e.getMessage());
        }
        return hotelList;
    }
    
        public static void setRooms(String hotelName, Hotel hotel, String dateFrom, String dateTo, String priceFrom, String priceTo, String grownUp, String children){
        //ArrayList<Room> roomList = new ArrayList<>();
        Connection c = null;
        try {
            c = getConnection();
            //String stmt = "SELECT userName FROM Users WHERE userName = " + username + " AND password = " + passwordHash;
            PreparedStatement p = c.prepareStatement("SELECT * FROM Room WHERE HotelName ='"+ hotelName + 
                    "' AND GrownUp LIKE '%" + grownUp + "%' AND Children LIKE '%" + children
                    + "%' AND Price BETWEEN '" + priceFrom + "' AND '" + priceTo + "';");
            //PreparedStatement p = c.prepareStatement("SELECT * FROM Room WHERE HotelName ='"+ hotelName + "';");
            ResultSet rs = p.executeQuery();
            while ( rs.next() ) {
                int id = rs.getInt("id");
                int price = rs.getInt("Price");
                int grownUps = rs.getInt("GrownUp");
                int child = rs.getInt("Children");
                
                ArrayList<LocalDate> isBooked = new ArrayList<>();
                hotel.addRoom(price, grownUps, child, isBooked);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("SELECT ERROR(setRooms): " + e.getMessage());
        }
    }
    
}
