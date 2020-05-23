package system.dictionary;

import system.dto.Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Offers implements Dictionary<Offer> {
    //  private static List<Offers> ofertas= new ArrayList<>();
    private final HashMap<String, Offer> offers = new HashMap<>();


    @Override
    public Offer get(String id) {
        return offers.get(id);
    }

    @Override
    public void put(String id, Offer object) {
        offers.put(id, object);
    }

    @Override
    public ArrayList<Offer> values() {
        return new ArrayList<>(offers.values());
    }

    @Override
    public Iterator<Offer> list() {
        return offers.values().iterator();
    }



}
