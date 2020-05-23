package system.test;

import org.junit.jupiter.api.Test;
import system.dto.Assignment;
import system.dto.Model;
import system.dto.rental.RentalOffice;
import system.dto.state.Car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void takeOutOfService() {
        Model model= new Model();
        model.setName("model1");

        Car car = new Car("0000");

        car.setModel(model);

        //  crear  4 coches
        // poner estado activo

        Car car1 = new Car("0001");
        Car car2 = new Car("0002");
        Car car3 = new Car("0003");

        car1.setModel(model);

        // 2 crear 2 oficinas
        RentalOffice rentalOffice= new RentalOffice("Office1");
        Assignment assignment = new Assignment(car, new Date(),null );
        Assignment assignment2 = new Assignment(car1, new Date(),null );
        rentalOffice.assignments.add( assignment);
        rentalOffice.assignments.add( assignment2);

        RentalOffice rentalOffice2= new RentalOffice("Office2");

        List<Car> cars= new ArrayList<>();

        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        car.setRentalOffice(rentalOffice);
        car1.setRentalOffice(rentalOffice);
        car2.setRentalOffice(rentalOffice);
        car3.setRentalOffice(rentalOffice);

        car1.setAsSustitute(new Date());


        //si devuelve nulo es que no hay coche
        car.takeOutOfService(new Date());
        car1.takeOutOfService(new Date());

        // poner estado de coche como fuera de servico y asegurarse de que coge sustituto
        // 3 a la misma oficina

        car.takeOutOfService(new Date());

        for (Car car5:cars) {
            System.out.println(car5.getEstado());
        }

        //intentar poner el sustituto fuera de servicio, debe fallar
        // intentar poner el fuera de servicio como fuera de servicio debe fallar
        //intentar poner el activo que queda fuera de servicio. Lo cambia y no devuelve sustituto
    }
}