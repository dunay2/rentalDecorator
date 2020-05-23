package decorator;

import com.company2.dto.Car;
import com.company2.dto.Customer;
import com.company2.dto.RentalOffice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class Rental  {
    private Customer customer;
    private Car car;
    public RentalOffice pickupOffice;
    private Date startDate;
    protected Date endDate;
    private String identifier;
    private Integer price;
    private List<Offer> ofertas= new ArrayList<>();

    public Integer getPrice() {

        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        int diff =(int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        int noOfferPrice= (this.car.getModelPricePerDay() *(diff+2));

        return (int )calculatePriceWithOffers  (noOfferPrice);
    }

    private double calculatePriceWithOffers (int  totalValue)
    {
        AbstractPrice abstractPrice= new ConcretPrice() ;
        abstractPrice.setValue(totalValue);

        for (Offer offer:ofertas
        ) {
            DiscountDecorator ofertaAux = DiscountFactory.getDiscountDecorator(abstractPrice, offer);
            ofertaAux.setValue (offer.getValor());
            abstractPrice= ofertaAux;
        }
        return (abstractPrice.getPrice() -abstractPrice.getDiscount());
    }


    public Rental() {
    }

    public Rental(String dni, Date startDate) {

        identifier=dni+startDate;
        this.startDate=startDate;
        ofertas=Offer.getOfertas();
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public RentalOffice getPickupOffice() {
        return pickupOffice;
    }

    public void setPickupOffice(RentalOffice pickupOffice) {
        this.pickupOffice = pickupOffice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public abstract void setEndDate(Date endDate);

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getIdentifier() {
        return identifier;
    }
}