package decorator;

import com.company2.services.CalculateNumberOfRentalsDO;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

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
