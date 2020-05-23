package decorator;

public class MoneyOffer extends DiscountDecorator {

    public MoneyOffer(AbstractPrice abstractThing) {
        this.abstractThing = abstractThing;
    }

    public String getDescription()
    {
        return abstractThing.getDescription() + ",   decorador 1";
    }

    @Override
    public double getDiscount() {
        return  Math.max(abstractThing.getDiscount(), value);
    }

}
