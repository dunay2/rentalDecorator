package system.dictionary;



import system.dto.state.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Cars implements Dictionary<Car> {
    private final HashMap<String, Car> cars = new HashMap<>();

    @Override
    public Iterator<Car> list() {
        return null;
    }

    @Override
    public Car get(String id) {
     return    cars.get(id);
    }

    @Override
    public void put(String id, Car object) {
        cars.put(id,object);
    }

    @Override
    public ArrayList<Car> values() {
        return new ArrayList<>(cars.values());
    }
}
