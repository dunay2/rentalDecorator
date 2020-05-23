package decorator;

public class ConcretPrice extends AbstractPrice {

    public ConcretPrice() {
        description="cosa concreta";
    }
    private  int costeBase;

    @Override
    public double getDiscount() {
        return 0;
    }

    @Override
    public double getPrice() {
        return costeBase;
    }

    @Override
    public void setValue(int value) {
        costeBase=value;
    }

}
