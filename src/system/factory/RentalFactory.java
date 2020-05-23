package system.factory;


import system.dto.rental.Rental;
import system.dto.rental.RentalOnsite;
import system.dto.rental.RentalType;
import system.dto.rental.WebRental;

import java.util.Date;

public  class RentalFactory {

    public static Rental getRentalByType(RentalType rentalType, String dni, Date inDate)
    {
        switch (rentalType)
        {
            case ONSITE:
                return new RentalOnsite(dni,inDate);
            case WEB:
                return new WebRental(dni,inDate);
        }
        return null;
    }

}
