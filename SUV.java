package CIT260;

/**
 * The SUV class
 * An object that represents a SUV and the options associated with it.
 * it inherits from the Car class but adds a four wheel drive option.
 */

public class SUV extends Car {
    // four wheel drive option
    private boolean fourWD;

    /**
     * Creates a SUV with base model options
     */
    public SUV() {
        fourWD = false;
    }

    /**
     * Creates a SUV with the given options
     *
     * @param fourByFour
     * @param driver
     * @param seats
     * @param suvColor
     * @param auto
     */
    public SUV(boolean fourByFour, String driver, int seats, String suvColor, boolean auto) {
        super(driver, seats, suvColor, auto);
        this.fourWD = fourByFour;
    }

    /**
     * The getFourWD method
     *
     * @return
     */
    public boolean getFourWD() {
        return fourWD;
    }

    /**
     * The setFourWD method
     *
     * @param fourByFour
     */
    public void setFourWD(boolean fourByFour) {
        this.fourWD = fourByFour;
    }

    /**
     * The createInvoice method overloads the base class method of the same name
     * and adds the SUV fourWD data to the invoice string
     *
     * @param suv
     * @param carNumber
     * @return
     */

    public String createInvoice(SUV suv, int carNumber) {
        // Get the invoice from the parent car class
        String invoice = super.createInvoice(suv, carNumber);

        // Add SUV options to it
        String powerTrain = "2 Wheel Drive";
        if (suv.getFourWD() == true) {
            powerTrain = "4 Wheel Drive";
        }
        invoice += "%nPower train: " + powerTrain;

        return invoice;
    }



}
