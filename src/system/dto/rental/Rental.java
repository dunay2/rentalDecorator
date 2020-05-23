package system.dto.rental;

import system.dto.Customer;
import system.dto.Offer;
import system.dto.state.Car;
import system.decorator.AbstractPrice;
import system.decorator.DiscountDecorator;
import system.decorator.DiscountFactory;
import system.dictionary.Offers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class Rental extends AbstractPrice {
    public RentalOffice pickupOffice;
    protected Date endDate;
    private Customer customer;
    private Car car;
    private Date startDate;
    private String identifier;
    protected double price = 0;
    private List<Offer> offers;

    public Rental(String dni, Date startDate) {
        identifier = dni + startDate;
        this.startDate = startDate;
        this.offers= new Offers().values();
    }

    public void setOffers(List<Offer> offers)
    {
        this.offers=offers;
    }

    public double getPrice() {

        if (price == 0) {
            price = calculateBasePrice();
        }
        return price;
    }


    public double recalculatePrice() {
        price=0;
        return getPrice();
    }

    private double calculateBasePrice() {
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        int diff = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        price = (this.car.getModelPricePerDay() * (diff + 2));

        AbstractPrice abstractPrice = this;

        for (Offer offer : offers
        ) {
            DiscountDecorator ofertaAux = DiscountFactory.getDiscountDecorator(abstractPrice, offer);
            ofertaAux.setValue(offer.getValor());
            abstractPrice = ofertaAux;
        }
        return (abstractPrice.getPrice() - abstractPrice.getDiscount());
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

    public void setValue(int value) {
        this.price=value;
    }

    public double getDiscount() {
        return 0;
    }
}