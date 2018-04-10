/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marinmcginley
 */
import java.lang.Object;
import java.time.LocalDate;
import java.util.ArrayList;

public class Room {
    private int priceForNight;
    private int numberOfAdults;
    private int numberOfChildren;
    private ArrayList<LocalDate> isBooked;
    
    public Room(int priceForNight, int numberOfAdults, int numberOfChildren, ArrayList<LocalDate> isBooked) {
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
    
    public ArrayList<LocalDate> getBookedDates() {
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

