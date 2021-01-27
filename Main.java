package CIT260;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    // Printstream and Scanner objects declared for taking in user vehicle options and printing invoice
    static PrintStream print = System.out;
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        // compOrder for tracking whether or not the order is completed
        boolean compOrder = false;

        // carCount for tracking whether the minimum requirement of three is fulfilled and offering to
        // complete order
        int carCount = 0;


        // explain to user purpose of program
        print.println("This program will walk you through the creation of your company’s new vehicle fleet.");
        print.println("A minimum of three vehicles will need to be ordered for the creation of your fleet. ");
        print.println("Let’s begin selecting your first vehicle and its options.");

        // Array of objects to store user selected vehicles
        ArrayList<Car> cars = new ArrayList<>(3);

        // the main menu loop to have the user initially select 3 vehicles and have the option to add more or
        // complete their order
        do {
            print.println("Enter ‘1’ for Car, ‘2’ for SUV, ‘3’ for Truck : ");
            int vehicleType = input.nextInt();

            switch (vehicleType) {
                case 1:
                    Car car = new Car();
                    setOptions(car);
                    cars.add(car);
                    break;
                case 2:
                    SUV suv = new SUV();
                    setOptions(suv);
                    print.println("Would you like 4 Wheel Drive?");
                    print.println("Enter 1 for Yes or 2 for No: ");
                    int drive = input.nextInt();
                    if (drive == 1) {
                        suv.setFourWD(true);
                    }
                    cars.add(suv);
                    break;
                case 3:
                    Truck truck = new Truck();
                    setOptions(truck);
                    print.println("Would you like the optional tow package?");
                    print.println("Enter 1 for Yes or 2 for No: ");
                    int tow = input.nextInt();
                    if (tow == 1) {
                        truck.setTowPackage(true);
                    }
                    cars.add(truck);
                    break;
                default: break;
            }
            carCount += 1;

            // after carCount reaches 3 , give user option to complete order or continue adding vehicles
            if (carCount >= 3) {
                print.println("Would you like to add another vehicle?");
                print.println("Enter 1 for Yes or 2 for No");
                int cont = input.nextInt();
                if (cont != 1) {
                    compOrder = true;
                }
            }
        } while (compOrder == false);

        // create new file object to write invoice
        try {
            File invoiceFile = new File("invoice.txt");
            if (!invoiceFile.exists()) {
                invoiceFile.createNewFile();
            }

            // create new Printwriter object and format output to write invoice to file
            try (PrintWriter toFile = new PrintWriter("invoice.txt")) {
                for (int i = 0; i < cars.size(); i++) {
                    Class carClass = cars.get(i).getClass();

                    if (carClass.getName().contains("Car")) {
                        toFile.printf(cars.get(i).createInvoice(cars.get(i), i + 1));
                    } else if (carClass.getName().contains("SUV")) {
                        toFile.printf(((SUV) cars.get(i)).createInvoice(((SUV)cars.get(i)), i + 1));
                    } else if (carClass.getName().contains("Truck")) {
                        toFile.printf(((Truck) cars.get(i)).createInvoice(((Truck)cars.get(i)), i + 1));
                    }

                }
            } catch (IOException ex) {

            }

            // create new Scanner ojbect and print out invoice details to the user
            try (Scanner theFile = new Scanner(invoiceFile)) {
                print.println("Order Details: ");
                while (theFile.hasNextLine()) {
                    print.println(theFile.nextLine());
                }
                print.println("Thank you for choosing us for your vehicle needs! Have a groovy day.");
            } catch (IOException ex) {

            }
        } catch (IOException ex) {

        }



    }

    /**
     * The setOptions method offers the standard options for each vehicle type to the user
     * and collects the option data from the user to create the object
     * @param car
     */

    public static void setOptions(Car car) {
        print.println("Who will be driving this car?");
        print.println("Name: ");
        String driverName = input.next();
        car.setDriverName(driverName);

        print.println("2 seats or 4 seats?");
        int seatNumber = input.nextInt();
        car.setSeats(seatNumber);

        print.println("What color?: ");
        String color = input.next();
        car.setColor(color);

        print.println("Transmission type?");
        print.println("Enter 1 for Automatic or 2 for Manual: ");
        int transmission = input.nextInt();
        if (transmission == 1) {
            car.setAutomatic(true);
        }
    }

}
