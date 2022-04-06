package addPromoInterface;

public class FullPrice implements Promotion{
    @Override
    public int getQuantity(int quantity) {
        return quantity;
    }
}
