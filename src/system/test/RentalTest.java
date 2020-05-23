package system.test;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import system.controller.RentalController;
import system.dictionary.Offers;
import system.dto.Offer;
import system.dto.rental.Rental;
import system.dto.rental.RentalOffice;
import system.dto.rental.WebRental;
import system.technicalservices.DataBase;


import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RentalTest {
    private Offers offers;

  //  @BeforeAll
   // void carga()
    //{
     //DataBase dataBase= new DataBase();
     //offers= dataBase.getOffers();
    //}


    @Test
    void setOffers() {

        this.offers= new Offers();

        setOffers(offers.values());
    }

    private void  setOffers (List<Offer> offers)
    {
        Rental rental= new WebRental("000",new Date());
        rental.setOffers(offers);

    }


    @Test
    Rental createRental()
    {
        String matricula="0000";
        String dniClient="0000";

        RentalOffice rentalOffice= new RentalOffice("RentalOffice1");

        RentalController rentalController = new RentalController() ;

        Date date= new Date();
        date.setDate(1) ;
        Date date2= new Date();
        date2.setDate(5) ;

        Rental rental;
        rental=  rentalController.createRental(dniClient, date,date2,matricula ,rentalOffice);

        assertEquals ( dniClient,rental.getCustomer().getDni());
        assertEquals ( matricula,rental.getCar().getLicensePlate());
        return rental;

    }

    @Test
    void testOffers()
    {
        double price;
        double realPrice=50;
        offers= new Offers();

        Rental rental=createRental();
        long diffInMillies = Math.abs(rental.getEndDate().getTime() - rental.getStartDate().getTime());
        int diff = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        price = (rental.getCar().getModelPricePerDay() * (diff + 2));

        assertEquals (realPrice,price);

        Offer oferta = new Offer("Descuento", 10);
        offers.put("oferta",oferta);
        rental.setOffers(offers.values());

        assertEquals (45,rental.getPrice());

        Offer oferta2 = new Offer("Descuento", 3);
        offers.put("oferta2 ", oferta2);
        rental.setOffers(offers.values());

        assertEquals (45,rental.recalculatePrice());

        Offer oferta3 = new Offer("Descuento", 20);
        offers.put("oferta3 ", oferta3);
        rental.setOffers(offers.values());

        assertEquals (40,rental.recalculatePrice());

        Offer oferta4 = new Offer("Dinero", 9);
        offers.put("oferta4 ", oferta4);
        rental.setOffers(offers.values());

        assertEquals (40,rental.recalculatePrice());

        Offer oferta5 = new Offer("Dinero", 11);
        offers.put("oferta5 ", oferta5);
        rental.setOffers(offers.values());

        assertEquals (39,rental.recalculatePrice());

    }


    @Test
    void getPrice() {
    }



}