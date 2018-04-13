
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import Model.Hotel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author marinmcginley
 */
public class DatabaseConnection {
    
    public static String hotelRoomTableName = "Hotel"; 

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
    
    
/*    public static void createHotel() {
        Connection c = null;
        Statement stmt = null;
        try {
          c = getConnection();
          System.out.println("createHotelRooms: Opened database successfully");
          stmt = c.createStatement();
          String sql = "CREATE TABLE " + DatabaseConnection.hotelRoomTableName +
                       " (nameOfHotel TEXT PRIMARY KEY NOT NULL," +
                       " location TEXT NOT NULL, " + 
                       " aviableForHandic INT NOT NULL, " +
                       " gym DATE NOT NULL, " +
                       " swimmingPool INT NOT NULL, " + 
                       " wifi TEXT NOT NULL, " +
                       " pickUp TEXT NOT NULL, " +
                       " breakfastIncluded INT NOT NULL)";
          stmt.executeUpdate(sql);
          stmt.close();
          c.close();
        } catch ( Exception e ) {
            System.out.println("CREATE TABLE ERROR: " + e.getClass().getName() + ": " + e.getMessage() );
        }
        System.out.println("Table created successfully");
    } */
    
    // Skilar true ef notendanafn er þegar í töflunni, annars false
    public static boolean checkIfUsernameExistsInTable(String username) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = getConnection();
            String query = "SELECT userName FROM Users WHERE userName IS " + username;
            PreparedStatement p = c.prepareStatement(query);
            ResultSet r = p.executeQuery();
            String un = r.getString(1);
            r.close();
            c.close();
            if (un.isEmpty()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("INSERT ERROR (í check): " + e.getMessage());
           
        }
        return false;
    }
    
    public static void insertUserIntoUsers(String username, String passwordHash) {
        Connection c = null;
        try {
            c = getConnection();
            String stmt = "INSERT INTO Users (userName, password) VALUES(" + username + "," + passwordHash + ")";
            PreparedStatement q = c.prepareStatement(stmt);
            q.executeUpdate();
            c.close();
            System.out.println("Innsetning á nýju notendanafni: " + username + ", og lykilorði tókst");
        } catch (Exception e) {
            System.out.println("INSERT ERROR: " + e.getMessage());
            return;
        }
    }
    
    public static boolean logIn(String username, String passwordHash) {
        Connection c = null;
        try {
            c = getConnection();
            String stmt = "SELECT userName FROM Users WHERE userName = " + username + " AND password = " + passwordHash;
            PreparedStatement p = c.prepareStatement(stmt);
            ResultSet r = p.executeQuery();
            String un = r.getString(1);
            if (un.isEmpty()) {
                System.out.println("Innskráning í DatabaseConnection hófst");
                return true;
            }
        } catch (Exception e) {
            System.out.println("INSERT ERROR: " + e.getMessage());
        }
        return false;
    }
    
    /*public static void insertIntoHotel(int id, String hotelName, String locationOfHotel, boolean aviableForHandic, boolean gym, boolean swimmingPool, boolean wifi, boolean pickUp, boolean breakfastIncluded, int grade, int numberOfGrade) {
        Connection c = null;
        try {
            c = getConnection();
            c.setAutoCommit(false);
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO Hotel VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, hotelName);
            pstmt.setString(3, locationOfHotel);
            pstmt.setBoolean(4, aviableForHandic);
            pstmt.setBoolean(5, gym);
            pstmt.setBoolean(6, swimmingPool);
            pstmt.setBoolean(7, wifi);
            pstmt.setBoolean(8, pickUp);
            pstmt.setBoolean(9, breakfastIncluded);
            pstmt.setInt(10, grade);
            pstmt.setInt(11, numberOfGrade);

            pstmt.executeUpdate();
            c.commit();
            pstmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println("INSERT ERROR: " + e.getMessage());
            return;
        }
        System.out.println("Tókst að bæta við hótel með hotelName: " + hotelName);
    }
    
    public static void insertIntoRoom(String hotelName, int adult, int child, int price, int id) {
        Connection c = null;
        try {
            c = getConnection();
            c.setAutoCommit(false);
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO Room VALUES(?,?,?,?,?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, hotelName);
            pstmt.setInt(3, adult);
            pstmt.setInt(4, child);
            pstmt.setInt(5, price);
            

            pstmt.executeUpdate();
            c.commit();
            pstmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println("INSERT ERROR: " + e.getMessage());
            return;
        }
        System.out.println("Tókst að bæta við herbergi fyrir hotelName: " + hotelName);
    }*/
    
    
    public static Hotel getHotelForName(String hotelNameIdentifier) {
        Hotel hotel = null;
        Connection c = null;

        Statement stmt = null;
        try {
            c = getConnection();
            c.setAutoCommit(false);
            System.out.println("getHotelForName: Tókst að opna gagnagrunn");

            stmt = c.createStatement();
            String query = String.format("SELECT * FROM %s WHERE nameOfHotel = '%s';",
            DatabaseConnection.hotelRoomTableName,
            hotelNameIdentifier);
            ResultSet rs = stmt.executeQuery(query);
            while ( rs.next() ) {
                //int id = rs.getInt("id");
                String hotelName = rs.getString("nameOfHotel");
                System.out.println(hotelName + " hotelname inní rs.next");
                String location = rs.getString("location");
                boolean aviableForHandic = rs.getBoolean("aviableForHandic");
                boolean gym = rs.getBoolean("gym");
                boolean swimmingPool = rs.getBoolean("swimmingPool");
                boolean wifi = rs.getBoolean("wifi");
                boolean pickUp = rs.getBoolean("pickUp");
                boolean breakfastIncluded = rs.getBoolean("breakfastIncluded");
                
                hotel = new Hotel(hotelName, location, aviableForHandic,gym, swimmingPool, wifi, pickUp, breakfastIncluded);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println("SELECT ERROR:" + e.getClass().getName() + ": " + e.getMessage() );
            return null;
        }
        System.out.println("Tókst að framkvæma SELECT");
        
        return hotel;
    }
    
    public static ArrayList<Hotel> getAllHotel() {
        ArrayList<Hotel> hotelList = new ArrayList<>();
        Connection c = null;

        Statement stmt = null;
        try {
            c = getConnection();
            c.setAutoCommit(false);
            System.out.println("getHotelForName: Tókst að opna gagnagrunn");

            stmt = c.createStatement();
            String query = String.format("SELECT * FROM Hotel;");
            ResultSet rs = stmt.executeQuery(query);
            while ( rs.next() ) {
                //int id = rs.getInt("id");
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
                hotelList.add(hotel);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println("SELECT ERROR:" + e.getClass().getName() + ": " + e.getMessage() );
            return null;
        }
        System.out.println("Tókst að framkvæma SELECT");
        
        return hotelList;
    }
    
}
