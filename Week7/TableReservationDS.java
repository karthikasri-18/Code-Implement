package Week7;

import java.util.HashMap;

abstract class Restaurant {
    protected HashMap<Integer, Integer> tableAvailability = new HashMap<>();
    
    public Restaurant() {
        tableAvailability.put(2, 6); 
        tableAvailability.put(4, 10); 
        tableAvailability.put(6, 4); 
    }
    
    public abstract int checkTableAvailability(int numberOfGuests) throws InvalidGuestException;
}

class InvalidGuestException extends Exception {
    public InvalidGuestException(String message) {
        super(message);
    }
}

class Reservation extends Restaurant {
    private String customerName;
    private int numberOfGuests;
    private String timeSlot;
    private String reservationStatus = "";
    
    public Reservation(String customerName, int numberOfGuests, String timeSlot) {
        this.customerName = customerName;
        this.numberOfGuests = numberOfGuests;
        this.timeSlot = timeSlot;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public int checkTableAvailability(int numberOfGuests) throws InvalidGuestException {
        System.out.println("Checking Table Availability for " + customerName + ":");
        if (numberOfGuests <= 0) {
            throw new InvalidGuestException("Invalid number of guests! Must be atleast 1.");
        }
        else if (numberOfGuests <= 2 && tableAvailability.get(2) > 0) {
            tableAvailability.put(2, tableAvailability.get(2) - 1);
            System.out.println("Table Available! Reservation Successful!");
            reservationStatus = "Successful";
            return 1;
        } 
        else if (numberOfGuests <= 4 && tableAvailability.get(4) > 0) {
            tableAvailability.put(4, tableAvailability.get(4) - 1);
            System.out.println("Table Available! Reservation Successful!");
            reservationStatus = "Successful";
            return 1;
        } 
        else if (numberOfGuests <= 6 && tableAvailability.get(6) > 0) {
            tableAvailability.put(6, tableAvailability.get(6) - 1);
            System.out.println("Table Available! Reservation Successful!");
            reservationStatus = "Successful";
            return 1;
        } 
        else {
            System.out.println("Sorry! No available table! Reservation failed!");
            reservationStatus = "Unsuccessful";
            return 0;
        }
        
    }

    public void displayReservationDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Number of Guests: " + numberOfGuests);
        System.out.println("Time Slot: " + timeSlot);
        System.out.println("Reservation Status: " + reservationStatus);
    }
}

public class TableReservationDS {
    public static void main(String[] args) {
        try {
            Reservation reserv1 = new Reservation("John", 4, "7:00 PM");
            reserv1.checkTableAvailability(reserv1.getNumberOfGuests());
            reserv1.displayReservationDetails();
        } 
        catch (InvalidGuestException e) {
            System.out.println("Error: " + e.getMessage());
        }
            
        try {
            Reservation reserv2 = new Reservation("Priya", -4, "4:30 PM");
            reserv2.checkTableAvailability(reserv2.getNumberOfGuests());
            reserv2.displayReservationDetails();
        } 
        catch (InvalidGuestException e) {
            System.out.println("Error: " + e.getMessage());
        }
     }
}