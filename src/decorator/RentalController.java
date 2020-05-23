package decorator;


import com.company.dictionary.Cars;
import com.company.dictionary.Customers;
import com.company.dictionary.RentalOffices;
import com.company.dictionary.Rentals;
import com.company2.dto.Car;
import com.company2.dto.Customer;
import com.company2.dto.Model;
import com.company2.dto.RentalOffice;

import com.company2.dto.rental.RentalType;


import java.util.Date;


public class RentalController {
    public Cars cars;
    public Customers customers;
    public Rentals rentals;
    public RentalOffices rentalOffices;

    public RentalController() {

        Model model= new Model();

        model.setPricePerDay(10);

        RentalOffice rentalOffice = new RentalOffice("RentalOffice1");

        cars = new Cars();

        Car car = new Car("0000");
        car.setRentalOffice(rentalOffice);
        car.setModel(model);
        cars.put(car.getLicensePlate(), car);

        Car car2 = new Car("1000");
        car.setModel(model);
        cars.put(car.getLicensePlate(), car);

        customers = new Customers();
        Customer customer = new Customer("0000", "Cliente prueba");

        customers.put(customer.getDni(), customer);
        rentals = new Rentals();

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
