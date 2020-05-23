package decorator;

import com.company.controller.RentalController;
import com.company.technicalservices.IRentalData;
import com.company.technicalservices.mySqlRental;
import com.company2.dto.RentalOffice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class main {


    public static void main(String[] args) {

        IRentalData dataAccess= new mySqlRental();
        RentalOffice rentalOffice= new RentalOffice("RentalOffice1");

        RentalController rentalController = new RentalController() ;

        Date date= new Date();
        date.setDate(1) ;
        Date date2= new Date();
        date2.setDate(5) ;

        Rental rental;
        rental=  rentalController.createRental("0000", date,date2,"0000",rentalOffice);

        System.out.println("el coste final de la reserva es " + rental.getPrice());



    }

}

