/*
Sér um að fara gegnum Hotel listann og hendir út þeim hótelum sem passa ekki við leitarskilyrði.
Fallið getAviableHotels() skilar síðan lista af hótelum sem eru laus m.v. leitarskilyrði.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    
    // Fyrir T
    public static ArrayList<Hotel> getHotels() {
        ArrayList<Hotel> hotelList = new ArrayList<>();
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement p = c.prepareStatement("SELECT * FROM Hotel;");
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
                double grade = rs.getDouble("grade");
                
                int getRoomId = getRoomID(hotelName);
                int getAdultPrice = getPrice(hotelName);
                int getChildPrice = (int) Math.round(getAdultPrice*0.5);
                Hotel hotel = null;
                hotel = new Hotel(hotelName, location, aviableForHandic,gym, swimmingPool, wifi, pickUp, breakfastIncluded, getAdultPrice, getChildPrice, getRoomId, grade);
                hotelList.add(hotel);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("SELECT ERROR(getHotels): " + e.getMessage());
        }
        return hotelList;
    }
    // Fyrir T
    public static int getRoomID(String hotelname){
        int roomId = 0;
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement p = c.prepareStatement("SELECT * FROM Room WHERE HotelName ='"+ hotelname + "';");
            ResultSet rs = p.executeQuery();
            System.out.println(rs.getInt("id"));
            roomId = rs.getInt("id");
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("SELECT ERROR(getRoomID): " + e.getMessage());
        }
        return roomId;
    }
    
    // Fyrir T
    public static int getPrice(String hotelname){
        int price = 0;
        int counter = 0;
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement p = c.prepareStatement("SELECT * FROM Room WHERE HotelName ='"+ hotelname + "';");
            ResultSet rs = p.executeQuery();
            while ( rs.next() ) {
                price =+ rs.getInt("Price");
                counter =+ 1;
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("SELECT ERROR(getPrice): " + e.getMessage());
        }
        return (price/counter);
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
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement p = c.prepareStatement("SELECT * FROM Room WHERE HotelName ='"+ hotelName + 
                    "' AND GrownUp LIKE '%" + grownUp + "%' AND Children LIKE '%" + children
                    + "%' AND Price BETWEEN '" + priceFrom + "' AND '" + priceTo + "';");
            ResultSet rs = p.executeQuery();
            while ( rs.next() ) {
                int id = rs.getInt("id");
                int price = rs.getInt("Price");
                int grownUps = rs.getInt("GrownUp");
                int child = rs.getInt("Children");
                
                ArrayList<Date> isBooked = getBookedDates(id);
                hotel.addRoom(id, price, grownUps, child, isBooked);
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("SELECT ERROR(setRooms): " + e.getMessage());
        }
    }
        
    public static ArrayList<Date> getBookedDates(int RoomId){
        Connection c = null;
        ArrayList<Date> bookedDates = new ArrayList<>();
        try {
            c = getConnection();
            PreparedStatement p = c.prepareStatement("SELECT * FROM BookedDates WHERE RoomID = " + RoomId + ";");
            ResultSet rs = p.executeQuery();
            while ( rs.next() ) {
                String bookedFrom = rs.getString("bookedfrom");
                String bookedTo = rs.getString("bookedto");
                Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(bookedFrom); 
                Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(bookedTo);
                while (date2.compareTo(date1) > 0) {
                    bookedDates.add(date1);
                    date1 = new Date(date1.getTime()+(1000*60*60*24));
                }
            }
            rs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("SELECT ERROR(getBookedDates): " + e.getMessage());
        }
        return bookedDates;
    }
}
