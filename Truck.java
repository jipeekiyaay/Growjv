package CIT260;

/**
 * The Truck class
 * An object that represents a Truck and the options associated with it.
 * it inherits from the Car class but adds a Tow Package option.
 */

public class Truck extends Car {
    // tow package option
    private boolean towPackage;

    /**
     * Creates a Truck with base model options
     */
    public Truck() {
        towPackage = false;
    }

    /**
     * Creates a Truck with the given options
     *
     * @param towPackage
     * @param driver
     * @param seats
     * @param suvColor
     * @param auto
     */
    public Truck(boolean towPackage, String driver, int seats, String suvColor, boolean auto) {
        super(driver, seats, suvColor, auto);
        this.towPackage = towPackage;
    }

    /**
     * The getTowPackage method
     *
     * @return
     */
    public boolean getTowPackage() {
        return towPackage;
    }

    /**
     * The setTowPackage method
     *
     * @param towPackage
     */
    public void setTowPackage(boolean towPackage) {
        this.towPackage = towPackage;
    }

    /**
     * The createInvoice method overloads the base class method of the same name
     * and adds the Truck towPackage data to the invoice string
     *
     * @param truck
     * @param carNumber
     * @return
     */

    public String createInvoice(Truck truck, int carNumber) {
        String invoice = super.createInvoice(truck, carNumber);

        String towCapable = "no tow capability";
        if (truck.getTowPackage() == true) {
            towCapable = "5,000 pound towing capacity";
        }
        invoice += "%nTow capability: " + towCapable;

        return invoice;
    }
}


