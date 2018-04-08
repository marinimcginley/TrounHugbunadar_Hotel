/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marinmcginley
 */
import java.util.ArrayList;
import java.lang.Object;
import java.time.LocalDate;

public class Hotel {
	
	public String nameOfHotel;
	public String locationOfHotel;
	public ArrayList<Room> rooms;
	public boolean aviableForHandic;
	public boolean pickUp;
	public boolean breakfastIncluded;
        public boolean wifi;
        public boolean swimmingPool;
        public boolean gym;

	public Hotel(String nameOfHotel, String locationOfHotel, boolean aviableForHandic, boolean wifi, boolean swimmingPool, boolean gym, boolean pickUp, boolean breakfastIncluded) {
		this.nameOfHotel = nameOfHotel;
		this.locationOfHotel = locationOfHotel;
		this.aviableForHandic = aviableForHandic;
                this.gym = gym;
                this.swimmingPool = swimmingPool;
                this.wifi = wifi;
                this.pickUp = pickUp;
                this.breakfastIncluded = breakfastIncluded;
	}

	public String getNameOfHotel() {
		return nameOfHotel;
	}

	public String getLocationOfHotel() {
		return locationOfHotel;
	}
        
        public boolean getAviableForHandic() {
            return aviableForHandic;
        }
        
        public boolean getPickUp() {
            return pickUp;
        }
        
        public boolean getBreakfastIncluded() {
            return breakfastIncluded;
        }
        
        public boolean getWifi() {
            return wifi;
        }
        
        public boolean getSwimmingPool() {
            return swimmingPool;
        }
        
        public boolean getGym() {
            return gym;
        }

	// Býr til herbergi fyrir þetta hótel
	public void addRoom(int priceForNight, int numberOfAdults, int numberOfChildren, LocalDate[] isBooked) {
		Room newRoom = new Room(priceForNight, numberOfAdults, numberOfChildren, isBooked);
		rooms.add(newRoom);
	}

	// skilar herbergjum fyrir þetta hotel
	public ArrayList<Room> viewRooms() {
		return rooms;
	}
}