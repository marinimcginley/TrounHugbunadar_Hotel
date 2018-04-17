package Model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marinmcginley
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Room {
    private final int priceForNight;
    private final int numberOfAdults;
    private final int numberOfChildren;
    private final ArrayList<Date> isBooked;
    
    public Room(int priceForNight, int numberOfAdults, int numberOfChildren, ArrayList<Date> isBooked) {
        this.priceForNight = priceForNight;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.isBooked = isBooked;
    }
    
    public int getPriceForNight() {
        return priceForNight;
    }
    
    public int getNumberOfAdults() {
        return numberOfAdults;
    }
    
    public int getNumberOfChildren() {
        return numberOfChildren;
    }
    
    public ArrayList<Date> getBookedDates() {
        return isBooked;
    }

    // Tekur inn lista af dagsetningum í samhangandi röð og tékkar hvort herbergið sé laust
    // Skilar true ef herbergið er laust á inntaki annars false
    public boolean isAvailable(LocalDate [] date) {
        for (int i=0; i<isBooked.size(); i++) {
            for (int j=0; j<date.length; j++) {
                if (isBooked.get(i).equals(date[j])) return false;
            }
        }
        return true;
    }
}
