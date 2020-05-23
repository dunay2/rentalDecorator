package system.dictionary;


import system.dto.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Customers  implements Dictionary<Customer> {

    private final HashMap<String, Customer> customers = new HashMap<>();

    @Override
    public Iterator<Customer> list() {
        return null;
    }

    @Override
    public Customer get(String id) {
     return  customers.get(id);
    }

    @Override
    public void put(String id, Customer object) {
customers.put(id,object);
    }

    @Override
    public ArrayList<Customer> values() {
        return new ArrayList<>(customers.values());
    }
}
