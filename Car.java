package CIT260;

/**
 * The Car class
 * An object that represents a car and the options associated with it.
 */
public class Car {
    // Driver of the fleet vehicle
    String driverName;

    // Number of seats in vehicle
    int seats;

    // Color of vehicle
    String color;

    // Transmission type of vehicle
    boolean automatic;

    /**
     * Creates a car with base model options
     */
    Car() {
        driverName = "N/A";
        seats = 2;
        color = "White";
        automatic = false;
    }

    /**
     * Creates a car with the given options
     * @param driverName
     * @param seats
     * @param color
     * @param automatic
     */
    Car(String driverName, int seats, String color, boolean automatic) {
        this.driverName = driverName;
        this.seats = seats;
        this.color = color;
        this.automatic = automatic;
    }

    /**
     * The setDriverName method
     * @param driverName
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * The setSeats method
     * @param seats
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * The setColor method
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * The setAutomatic method
     * @param automatic
     */
    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    /**
     * The createInvoice method
     * Creates a string that contains the options of the given fleet vehicle
     * @param car
     * @return invoice
     */
    protected String createInvoice(Car car, int carNumber) {
        // Create the invoice string
        String invoice = "";

        // Append each option to the invoice
        invoice += "%n%nCar " + carNumber;
        invoice += "%nDriver: " + car.driverName;
        invoice += "%nNumber of seats: " + car.seats;
        invoice += "%nColor: " + car.color;
        String trans = "Manual";
        if (car.automatic == true) {
            trans = "Automatic";
        }
        invoice += "%nTransmission: " + trans;

        return invoice;
    }
}
