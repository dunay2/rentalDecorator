package decorator;

import com.company2.services.CalculateNumberOfRentalsDO;


import java.util.List;

public class CalculateNumRentals implements CalculateNumberOfRentalsDO {

    public Integer calculate(List<Rental> rentals) {
        int i = 0;
        for (Rental rental : rentals
        ) {
            if (rental instanceof WebRental)
            {
                WebRental webRental=(WebRental) rental;
                if (webRental.getPickupOffice().equals(webRental.getDeliveryOffice())) {
                    i++;
                }
            }
        }return i;
    }
}

