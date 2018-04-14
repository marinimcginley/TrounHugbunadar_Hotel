
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import Model.Hotel;
import Model.Room;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
            System.out.println(e.getMessage());
           
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
        }
        return;
    }
    
    // skilar true ef notendanafn passar við lykilorð í gagnagrunni, annars false
    public static boolean logIn(String username, String passwordHash) {
        Connection c = null;
        try {
            
            c = getConnection();
            
            System.out.println("passwordHash: " + passwordHash);
            String stmt = "SELECT userName FROM Users WHERE userName = '" + username + "' AND password = '" + passwordHash + "'";
            PreparedStatement p = c.prepareStatement(stmt);
            ResultSet r = p.executeQuery();
            String un = r.getString(1);
            System.out.println(un);
            r.close();
            c.close();
            if (un.isEmpty()) {
                System.out.println("false í login");
                return false;
            } else {
                System.out.println("true í login");
                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
        
    }
    
}
