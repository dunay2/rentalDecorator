package decorator;

public abstract class AbstractPrice {
    String description = "Cosa base";

    public String getDescription() {
        return description;
    }

    public abstract double getDiscount();
    public abstract double getPrice();
    public abstract void setValue(int value);

}