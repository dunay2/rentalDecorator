package decorator;

import com.company2.dto.rental.Rental;

import java.util.Date;

public class RentalOnsite extends Rental {
    public RentalOnsite(String dni, Date startDate) {
        super(dni, startDate);
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate=endDate;
    }
}
