/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import JFrame.Index;
import Model.Hotel;

/**
 *
 * @author Bob
 */
public class Main {

    private static void setUpDatabase() {
        DatabaseConnection.insertIntoHotel("Hotel Bifrost","Sudurland", true, true, true, true, true, true);
    }
    
    public static void main(String args[]) {
        Main.setUpDatabase();
        
        Index frame = new Index();
        frame.setVisible(true);
    }
        
        
}
