package decorator;

public class DiscountFactory {

    public static DiscountDecorator getDiscountDecorator(AbstractPrice abstractPrice, Offer localOferta) {
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


}
