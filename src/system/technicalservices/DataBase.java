package system.technicalservices;

import system.dictionary.*;
import system.dto.Assignment;
import system.dto.Customer;
import system.dto.Model;
import system.dto.Offer;
import system.dto.rental.RentalOffice;
import system.dto.state.Car;

import java.util.Date;

public class DataBase implements IRentalData {
    private Cars cars;
    private Customers customers;
    private final Rentals rentals;
    private RentalOffices rentalOffices;
    private Offers offers;

    public DataBase() {
        Model model = new Model();
        model.setName("modelo 1");
        model.setPricePerDay(10);

        RentalOffice rentalOffice = new RentalOffice("RentalOffice1");
        initializeCustomers();
        initializeCars(rentalOffice, model);

        for (Car car : cars.values()
        ) {
            rentalOffice.assignments.add(createAssignement(car));
        }

        rentals = new Rentals();
    }

    private Assignment createAssignement(Car car) {
        return new Assignment(car, new Date(), null);
    }


    private void initializeCars(RentalOffice rentalOffice, Model model) {
        cars = new Cars();
        Car car = new Car("0000");
        car.setRentalOffice(rentalOffice);
        car.setModel(model);
        cars.put(car.getLicensePlate(), car);
        Car car2 = new Car("1000");
        car2.setModel(model);
        cars.put(car2.getLicensePlate(), car2);
    }

    private void initializeCustomers() {
        customers = new Customers();
        Customer customer = new Customer("0000", "Cliente prueba");
        customers.put(customer.getDni(), customer);
    }


    @Override
    public void add(Object rental) {

    }

    public Cars getCars() {
        return cars;
    }

    public RentalOffices getRentalOffices() {
        return rentalOffices;
    }

    public Customers getCustomers() {
        return customers;

    }

    public Offers getOffers() {
        return offers;
    }


    private void initializeOffers() {

        Offer oferta = new Offer("Descuento", 10);
        offers.put("oferta ", oferta);
        Offer oferta2 = new Offer("Descuento", 3);
        offers.put("oferta2 ", oferta2);
        Offer oferta3 = new Offer("Descuento", 4);
        offers.put("oferta3 ", oferta3);
        Offer oferta4 = new Offer("Dinero", 10);
        offers.put("oferta4 ", oferta4);
        Offer oferta5 = new Offer("Dinero", 17);
        offers.put("oferta5 ", oferta5);
    }


}



