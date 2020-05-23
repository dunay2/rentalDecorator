package decorator;

import com.company2.dto.RentalOffice;


import java.util.Date;

public class WebRental  extends Rental {
    private int deliveryTime;
    private RentalOffice deliveryOffice;

    public RentalOffice getDeliveryOffice() {
        return deliveryOffice;
    }

    public void setDeliveryOffice(RentalOffice deliveryOffice) {
        this.deliveryOffice = deliveryOffice;
    }

    public WebRental(String dni, Date startDate) {
        super(dni, startDate);
    }

    @Override
    public void setEndDate(Date endDate) {

        if (pickupOffice.getAddress().equals( deliveryOffice.getAddress()))
        {
            endDate.setHours(13);
            endDate.setMinutes(00);
        }
        this.endDate=endDate;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {

            this.deliveryTime=deliveryTime;

    }


    @Override
    public Integer getPrice()
    {
    return  super.getPrice()+this.deliveryOffice.getFeeForDelivery();
    }


}
