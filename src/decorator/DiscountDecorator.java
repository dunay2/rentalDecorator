package decorator;

public abstract class DiscountDecorator extends AbstractPrice {
    AbstractPrice abstractThing;
    protected int value;

    public String getDescription() {
        return description;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public double getPrice() {
        return abstractThing.getPrice();
    }
}
