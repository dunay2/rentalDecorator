package decorator;

import java.util.ArrayList;
import java.util.List;

public  class Offer
{
    private static List<Offer> ofertas= new ArrayList<>();
    private String tipo;
    private int valor;

    public Offer(String tipo, int valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }


    public static List getOfertas()
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

}
