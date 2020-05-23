package system.strategy;
import system.dto.rental.Rental;

import java.util.List;

public interface CalculateNumberOfRentalsDO {

    public Integer calculate(List<Rental>rentals);
}
