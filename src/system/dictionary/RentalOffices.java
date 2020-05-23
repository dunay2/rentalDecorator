package system.dictionary;



import system.dto.rental.RentalOffice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class RentalOffices implements Dictionary<RentalOffice> {

    private HashMap<String, RentalOffice> rentalOffices= new HashMap<>();

    @Override
    public Iterator<RentalOffice> list() {
        return null;
    }

    @Override
    public RentalOffice get(String id) {
        return rentalOffices.get(id);
    }

    @Override
    public void put(String id, RentalOffice object) {
        put(id,object);
    }

    @Override
    public ArrayList<RentalOffice> values() {
       return new ArrayList<>(rentalOffices.values());
    }


}
