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

        return (int )calculateOffers  (noOfferPrice);
    }

    private double calculateOffers (int  totalValue)
    {
        AbstractPrice abstractPrice= new ConcretPrice() ;
        abstractPrice.setValue(totalValue);

        for (Offer offer:ofertas
        ) {
            //poner una factoria
            DiscountDecorator ofertaAux = getDiscountDecoratorFactory(abstractPrice, offer);
            ofertaAux.setValue (offer.getValor());
            abstractPrice= ofertaAux;
        }
        return (abstractPrice.getPrice() -abstractPrice.getDiscount());
    }

    private DiscountDecorator getDiscountDecoratorFactory(AbstractPrice abstractPrice, Offer localOferta) {
        DiscountDecorator ofertaAux;
        if (localOferta.getTipo().equals("Descuento"))
        {
            ofertaAux = new DiscountOffer(abstractPrice);
        }
        else
        {
            ofertaAux = new MoneyOffer(abstractPrice);
        }
        return ofertaAux;
    }

    public Rental() {
    }

    public Rental(String dni, Date startDate) {

        identifier=dni+startDate;
        this.startDate=startDate;
        ofertas=getOfertas();

    }

    private List getOfertas()
    {

        Offer oferta= new Offer("Descuento", 10);
        Offer oferta2= new Offer("Descuento", 3);
        Offer oferta3= new Offer("Descuento", 4);
        Offer oferta4= new Offer("Dinero", 10);
        Offer oferta5= new Offer("Dinero", 17);

        ofertas.add(oferta);
       //  ofertas.add(oferta2);
       //ofertas.add(oferta3);
       //  ofertas.add(oferta4);
      ofertas.add(oferta5);

         return ofertas;
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
