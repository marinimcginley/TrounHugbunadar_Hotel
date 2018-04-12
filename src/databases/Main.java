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
        DatabaseConnection.insertIntoHotel("Hotel Jökull","Höfn", false, true, true, true, false, true);
        DatabaseConnection.insertIntoRoom("Hotel Jökull", 2, 0, 12879,1);
        DatabaseConnection.insertIntoRoom("Hotel Jökull", 2, 2, 18579,2);
        DatabaseConnection.insertIntoHotel("CenterHotel Plaza","Reykjavík", true, false, false, true, true, false);
        DatabaseConnection.insertIntoRoom("CenterHotel Plaza", 2, 1, 14778,3);
        DatabaseConnection.insertIntoRoom("CenterHotel Plaza", 1, 0, 9875,4);
        DatabaseConnection.insertIntoHotel("Hotel Borg","Keflavík", true, true, true, true, false, false);
        DatabaseConnection.insertIntoRoom("Hotel Borg", 2, 0, 15589,5);
        DatabaseConnection.insertIntoRoom("Hotel Borg", 2, 1, 17789,6);
        DatabaseConnection.insertIntoHotel("UMI Hotel","Eyvindarhólar", true, true, true, false, false, false);
        DatabaseConnection.insertIntoRoom("UMI Hotel", 1, 0, 12879,7);
        DatabaseConnection.insertIntoHotel("Fosshotel Lind","Vestmannaeyjar", false, true, false, true, true, true);
        DatabaseConnection.insertIntoRoom("Fosshotel Lind", 2, 1, 16478,8);
        DatabaseConnection.insertIntoRoom("Fosshotel Lind", 2, 2, 24332,9);
        DatabaseConnection.insertIntoRoom("Fosshotel Lind", 2, 0, 15624,10);
        DatabaseConnection.insertIntoHotel("Hotel Fransiskus","Stykkishólmur", true, false, false, true, false, true);
        DatabaseConnection.insertIntoRoom("Hotel Fransiskus", 2, 1, 11473,11);
        DatabaseConnection.insertIntoRoom("Hotel Fransiskus", 2, 0, 8741,12);
        DatabaseConnection.insertIntoHotel("Hotel Rjúkandi","Egilsstaðir", true, true, true, true, true, false);
        DatabaseConnection.insertIntoRoom("Hotel Rjúkandi", 2, 0, 11458,13);
        DatabaseConnection.insertIntoHotel("Hotel Acco","Akureyri", false, true, false, true, true, true);
        DatabaseConnection.insertIntoRoom("Hotel Acco", 1, 1, 15749,14);
        DatabaseConnection.insertIntoRoom("Hotel Acco", 1, 0, 14469,15);
        DatabaseConnection.insertIntoHotel("Geo Hótel ","Grindavík", true, false, false, true, false, true);
        DatabaseConnection.insertIntoRoom("Geo Hótel", 2, 0, 19875,16);
        DatabaseConnection.insertIntoRoom("Geo Hótel", 2, 2, 25472,17);
        DatabaseConnection.insertIntoRoom("Geo Hótel", 2, 0, 17746,18);
        DatabaseConnection.insertIntoHotel("Hafdals Hotel","Akureyri", true, false, true, true, false, true);
        DatabaseConnection.insertIntoRoom("Hafdals Hotel", 2, 0, 17852,19);
        DatabaseConnection.insertIntoRoom("Hafdals Hotel", 2, 1, 16632,20);
        DatabaseConnection.insertIntoHotel("Hotel Viking","Egilsstaðir", false, false, false, true, false, false);
        DatabaseConnection.insertIntoRoom("Hotel Viking", 2, 1, 17741,21);
        DatabaseConnection.insertIntoRoom("Hotel Viking", 2, 0, 12879,22);
        DatabaseConnection.insertIntoHotel("City Park Hotel","Reykjavík", true, false, true, true, true, true);
        DatabaseConnection.insertIntoRoom("City Park Hotel", 2, 0, 19987,23);
        DatabaseConnection.insertIntoHotel("Hotel Tangs","Ísafjörður", false, true, false, true, false, true);
        DatabaseConnection.insertIntoRoom("Hotel Tangs", 2, 2, 18214,24);
        DatabaseConnection.insertIntoRoom("Hotel Tangs", 1, 0, 12245,25);
        DatabaseConnection.insertIntoHotel("Hotel Lækur","Hella", true, true, true, true, false, true);
        DatabaseConnection.insertIntoRoom("Hotel Lækur", 2, 1, 14579,26);
        DatabaseConnection.insertIntoRoom("Hotel Lækur", 2, 0, 23657,27);
        DatabaseConnection.insertIntoHotel("Borealis Hotel","Borgarnes", false, true, true, true, false, false);
        DatabaseConnection.insertIntoRoom("Borealis Hotel", 2, 0, 15896,28);
        DatabaseConnection.insertIntoRoom("Borealis Hotel", 2, 1, 17824,29);
        DatabaseConnection.insertIntoHotel("Hotel húsafell","Húsafell", true, true, true, true, false, true);
        DatabaseConnection.insertIntoRoom("Hotel húsafell", 2, 0, 14752,30);
    }
    
    public static void main(String args[]) {
        Main.setUpDatabase();
        
        Index frame = new Index();
        frame.setVisible(true);
    }
        
        
}
