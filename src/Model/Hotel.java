package Model;

/**
 *
 * @author marinmcginley
 */
import java.util.ArrayList;
import java.util.Date;

public class Hotel {
    
	public ArrayList<Room> rooms = new ArrayList<>();
	public String nameOfHotel;
	public String locationOfHotel;
	public boolean aviableForHandic;
        public boolean gym;
        public boolean swimmingPool;
        public boolean wifi;
	public boolean pickUp;
	public boolean breakfastIncluded;
        public int adultPrice;// Fall til að framkvæma föll fyrir T hóp
        public int childPrice;// Fall til að framkvæma föll fyrir T hóp
        int roomID;// Fall til að framkvæma föll fyrir T hóp
        double grade;

        // Fall til að framkvæma föll fyrir T hóp
    public Hotel(String nameOfHotel, String locationOfHotel, boolean aviableForHandic, boolean gym, boolean swimmingPool, boolean wifi, boolean pickUp, boolean breakfastIncluded, int adultPrice, int childPrice, int roomID, double grade) {
            this.nameOfHotel = nameOfHotel;
            this.locationOfHotel = locationOfHotel;
            this.aviableForHandic = aviableForHandic;
            this.gym = gym;
            this.swimmingPool = swimmingPool;
            this.wifi = wifi;
            this.pickUp = pickUp;
            this.breakfastIncluded = breakfastIncluded;
            this.adultPrice = adultPrice;
            this.childPrice = childPrice;
            this.roomID = roomID;
            this.grade = grade;
    }
    
    public Hotel(String nameOfHotel, String locationOfHotel, boolean aviableForHandic, boolean gym, boolean swimmingPool, boolean wifi, boolean pickUp, boolean breakfastIncluded) {
            this.nameOfHotel = nameOfHotel;
            this.locationOfHotel = locationOfHotel;
            this.aviableForHandic = aviableForHandic;
            this.gym = gym;
            this.swimmingPool = swimmingPool;
            this.wifi = wifi;
            this.pickUp = pickUp;
            this.breakfastIncluded = breakfastIncluded;
    }

    /**
     *
     * @param nameOfHotel
     * @param locationOfHotel
     * @param aviableForHandic
     * @param wifi
     * @param swimmingPool
     * @param gym
     * @param pickUp
     * @param breakfastIncluded
     * */

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
        // Fall til að framkvæma föll fyrir T hóp
        public int getAdultPrice(){
            return adultPrice;
        }
        // Fall til að framkvæma föll fyrir T hóp
        public int getChildPrice(){
            return childPrice;
        }
        // Fall til að framkvæma föll fyrir T hóp
        public int getRoomId(){
            return roomID;
        }
        // Fall til að framkvæma föll fyrir T hóp
        public double getGrade(){
            return grade;
        }

	// Býr til herbergi fyrir þetta hótel
    public void addRoom(int roomId, int priceForNight, int numberOfAdults, int numberOfChildren, ArrayList<Date> isBooked) {
		Room newRoom = new Room(roomId, priceForNight, numberOfAdults, numberOfChildren, isBooked);
                rooms.add(newRoom);
	}

	// skilar herbergjum fyrir þetta hotel
	public ArrayList<Room> viewRooms() {
		return rooms;
	}
}