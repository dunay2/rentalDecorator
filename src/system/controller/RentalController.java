package system.controller;


import system.dictionary.Cars;
import system.dictionary.Customers;
import system.dictionary.RentalOffices;
import system.dictionary.Rentals;
import system.dto.Customer;
import system.dto.state.Car;
import system.dto.rental.RentalOffice;
import system.dto.rental.RentalType;
import system.dto.rental.Rental;
import system.dto.rental.WebRental;
import system.technicalservices.DataBase;


import java.util.Date;


public class RentalController {
    private Cars cars;
    private Customers customers;
    private Rentals rentals;
    private RentalOffices rentalOffices;

    public RentalController() {

        DataBase dataBase= new DataBase();
        cars=dataBase.getCars();
        customers=dataBase.getCustomers();
        rentalOffices=dataBase.getRentalOffices();

    }


    public Rental createRental(String dni, Date iDate, Date oDate, String lPlate, RentalOffice delOffice) {

        Car car = cars.get(lPlate);

        RentalOffice rentalOffice = car.getRentalOffice();
        Customer customer = customers.get(dni);

        Rental webRental = rentalOffice.createRental(dni, iDate, oDate, lPlate, delOffice, RentalType.WEB);

        webRental.setCustomer(customer);
        return webRental;
    }



    public Rental setWebRentaldeliveryTime(String key, Integer time) {
        Rental rental = rentals.get(key);

        ((WebRental) rental).setDeliveryTime(time);

        return rental;
    }

}
