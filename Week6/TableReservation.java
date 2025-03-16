package Week6;

abstract class Restaurant {
    protected int numberOf2Seaters = 6;
    protected int numberOf4Seaters = 10;
    protected int numberOf6Seaters = 4;

    public abstract boolean checkTableAvailability(int numberOfGuests);
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
    public boolean checkTableAvailability(int numberOfGuests) {
        System.out.println("Checking Table Availability for " + customerName + ":");
        if (numberOfGuests <= 0) {
            System.out.println("Invalid number of guests!");
            reservationStatus = "Unsuccessful";
            return false;
        } else if (numberOfGuests <= 2 && numberOf2Seaters > 0) {
            numberOf2Seaters--;
            System.out.println("Table Available! Reservation Successful!");
            reservationStatus = "Successful";
            return true;
        } else if (numberOfGuests <= 4 && numberOf4Seaters > 0) {
            numberOf4Seaters--;
            System.out.println("Table Available! Reservation Successful!");
            reservationStatus = "Successful";
            return true;
        } else if (numberOfGuests <= 6 && numberOf6Seaters > 0) {
            numberOf6Seaters--;
            reservationStatus = "Successful";
            System.out.println("Table Available! Reservation Successful!");
            reservationStatus = "Unsuccessful";
            return true;
        } else {
            System.out.println("Sorry! Table is not available! Reservation failed!");
            return false;
        }
    }

    public void displayReservationDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Number of Guests: " + numberOfGuests);
        System.out.println("Time Slot: " + timeSlot);
        System.out.println("Reservation Status: " + reservationStatus);
    }
}

public class TableReservation {
    public static void main(String[] args) {
        Reservation reserv1 = new Reservation("John", 4, "7:00 PM");
        reserv1.checkTableAvailability(reserv1.getNumberOfGuests());
        reserv1.displayReservationDetails();

        Reservation reserv2 = new Reservation("Priya",-4,"7:30");
        reserv2.checkTableAvailability(reserv2.getNumberOfGuests());
        reserv2.displayReservationDetails();
    }
}

