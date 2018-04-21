
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import Model.Booking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public static ArrayList<Booking> getBookings(String username) {
        Connection c = null;
        Statement stmt = null;
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        try {
            c = getConnection();
            String query = "SELECT Hotel.nameOfHotel, Hotel.location, Room.price, BookedDates.BookedFrom, BookedDates.BookedTo " +
                    "FROM Hotel, Room, BookedDates " +
                    "WHERE Hotel.nameOfHotel = Room.HotelName And " +
                    "Room.id = BookedDates.roomID AND " +
                    "BookedDates.userName = '" + username + "'";
            PreparedStatement p = c.prepareStatement(query);
            ResultSet r = p.executeQuery();
            

            while (r.next()) {
                bookings.add(new Booking(r.getString("nameOfHotel"), r.getString("location"), r.getInt("price"),
                        r.getString("BookedFrom"), r.getString("BookedTo")));
            }
        } catch (Exception e) {
            System.out.println("SELECT ERROR (getBookings): " + e.getMessage()); 
        }
        return bookings;
    }
    
    public static void createBooking(int roomID, String from, String to, String userName) {
        Connection c = null;
        try {
            c = getConnection();
            String stmt = "INSERT INTO BookedDates (roomID, userName, BookedFrom, BookedTo) VALUES('" + roomID + "', '"+ userName + "','" + from + "', '" + to + "')";
            PreparedStatement q = c.prepareStatement(stmt);
            q.executeUpdate();
            c.close();
            System.out.println("Innsetning á booking:  tókst");
        } catch (Exception e) {
            System.out.println("INSERT ERROR (createBooking): " + e.getMessage());
        }
        return;
    }
    
    // Skilar true ef notendanafn er þegar í töflunni, annars false
    public static boolean checkIfUsernameExistsInTable(String username) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = getConnection();
            String query = "SELECT userName FROM Users WHERE userName IS '" + username + "'";
            PreparedStatement p = c.prepareStatement(query);
            ResultSet r = p.executeQuery();
            String un = r.getString(1);
            r.close();
            c.close();
            if (un.isEmpty()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("SELECT ERROR (checkIfUsernameExists): " + e.getMessage());
           
        }
        return false;
    }
    
    public static void insertUserIntoUsers(String username, String passwordHash) {
        Connection c = null;
        try {
            c = getConnection();
            String stmt = "INSERT INTO Users (userName, password) VALUES('" + username + "','" + passwordHash + "')";
            PreparedStatement q = c.prepareStatement(stmt);
            q.executeUpdate();
            c.close();
            System.out.println("Innsetning á nýju notendanafni: " + username + ", og lykilorði tókst");
        } catch (Exception e) {
            System.out.println("SELECT ERROR (insertUserIntoUsers): " + e.getMessage());
        }
        return;
    }
    
    // skilar true ef notendanafn passar við lykilorð í gagnagrunni, annars false
    public static boolean logIn(String username, String passwordHash) {
        Connection c = null;
        try {
            c = getConnection();
            String stmt = "SELECT userName FROM Users WHERE userName = '" + username + "' AND password = '" + passwordHash + "'";
            PreparedStatement p = c.prepareStatement(stmt);
            ResultSet r = p.executeQuery();
            String un = r.getString(1);
            System.out.println(un);
            r.close();
            c.close();
            if (un.isEmpty()) {
                return false;
            } else {
                return true;
            }
            
        } catch (Exception e) {
            System.out.println("SELECT ERROR(logIn): " + e.getMessage());
        }
        return false;
        
    }
    
}
