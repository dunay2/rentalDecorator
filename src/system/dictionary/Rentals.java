package system.dictionary;


import system.dto.rental.Rental;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Rentals implements Dictionary<Rental> {
    //private final IRentalData dataAccess;
    private final HashMap<String, Rental> rentals = new HashMap<>();


        //public Rentals(IRentalData dataAccess) {
        //this.dataAccess = dataAccess;
    //}

    @Override
    public Iterator<Rental> list() {
        return rentals.values().iterator();
    }

    @Override
    public Rental get(String id) {
        return rentals.get(id);
    }

    @Override
    public void put(String id, Rental object) {
        rentals.put(id, object);
      //  dataAccess.add(object);
    }

    @Override
    public ArrayList<Rental> values() {
        return new ArrayList<>(rentals.values());
    }
}
