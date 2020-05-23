package system.dto;

import system.dto.rental.Rental;
import system.strategy.CalculateNumberOfRentalsDO;

import java.util.ArrayList;

public class Customer { private String dni;
private String name;
private ArrayList<Rental> rentals;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Customer() {
    }

    public Customer(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer numberOfRentalsWithDifferentOffices(CalculateNumberOfRentalsDO calculateNumberOfRentalsDO)
    {

        return calculateNumberOfRentalsDO.calculate(rentals);
    }

}
