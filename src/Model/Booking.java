/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author marinmcginley
 */
public class Booking {
    
    public ArrayList<Booking> bookings = new ArrayList<Booking>();
    private String nameOfHotel;
    private String locationOfHotel;
    private int price;
    private int numberOfAdults;
    private int numberOfChildren;
    private boolean availableForHandic;
    private boolean gym;
    private boolean swimmingPool;
    private boolean wifi;
    private boolean pickUp;
    private boolean breakfastIncluded;
    private LocalDate firstDate;
    private LocalDate lastDate;
    
    public Booking(String nameOfHotel, String locationOfHotel, int price,
            int numberOfAdults, int numberOfChildren, boolean availableForHandic,
            boolean gym, boolean swimmingPool, boolean wifi, boolean pickUp,
            boolean breakfastIncluded, LocalDate firstDate, LocalDate lastDate) {
        this.nameOfHotel = nameOfHotel;
        this.locationOfHotel = locationOfHotel;
        this.price = price;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.availableForHandic = availableForHandic;
        this.gym = gym;
        this.swimmingPool = swimmingPool;
        this.wifi = wifi;
        this.pickUp = pickUp;
        this.breakfastIncluded = breakfastIncluded;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }
    
    public LocalDate getFirstDate() {
        return firstDate;
    }
    
    public LocalDate getLastDate() {
        return lastDate;
    }
    
    public String getNameOfHotel() {
        return nameOfHotel;
    }
    
    public String getLocationOfHotel() {
        return locationOfHotel;
    }
    
    public int getPrice() {
        return price;
    }
    
    public int getNumberOfAdults() {
        return numberOfAdults;
    }
    
    public int getNumberOfChildren() {
        return numberOfChildren;
    }
    
    public boolean getHandicapped() {
        return availableForHandic;
    }
    
    public boolean getGym() {
        return gym;
    }
    
    public boolean getSwimmingPool() {
        return swimmingPool;
    }
    
    public boolean getWifi() {
        return wifi;
    }
    
    public boolean getPickUp() {
        return pickUp;
    }
    
    public boolean getBreakfast() {
        return breakfastIncluded;
    }
    
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
    
    public ArrayList<Booking> viewBookings() {
	return bookings;
    }
    
}
