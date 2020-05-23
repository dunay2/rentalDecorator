package decorator;

public class DiscountOffer extends DiscountDecorator {

    public DiscountOffer(AbstractPrice abstracCosa) {
        this.abstractThing = abstracCosa;
    }

    public String getDescription()
    {
        return abstractThing.getDescription() + ",   decorador 2";
    }

    @Override
    public double getDiscount() {
        return  Math.max(abstractThing.getDiscount(), ( abstractThing.getPrice()/100)*value);
    }

}


