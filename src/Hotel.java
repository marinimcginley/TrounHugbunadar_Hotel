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
	//public boolean aviableForHandic;
	//public boolean pickUp;
	//public boolean breakfastIncluded;
	public LocalDate checkInStart;
	public LocalDate checkInFinish;

	public Hotel(String nameOfHotel, String locationOfHotel) {
		this.nameOfHotel = nameOfHotel;
		this.locationOfHotel = locationOfHotel;
		//this.checkInStart = checkInStart;
		//this.checkInFinish = checkInFinish;
	}

	public String getNameOfHotel() {
		return nameOfHotel;
	}

	public String getLocationOfHotel() {
		return locationOfHotel;
	}

	/*public Date getCheckInStart() {
		return checkInStart;
	}

	public Date getCheckInFinish() {
		return checkInFinish;
	}*/

	// Býr til herbergi fyrir þetta hótel
	public void addRoom(int priceForNight, int numberOfAdults, int numberOfChildren, LocalDate[] isBooked) {
		Room roomTest = new Room(priceForNight, numberOfAdults, numberOfChildren, isBooked);
		rooms.add(roomTest);
	}

	// skilar herbergjum fyrir þetta hotel
	public ArrayList<Room> viewRooms() {
		return rooms;
	}
}