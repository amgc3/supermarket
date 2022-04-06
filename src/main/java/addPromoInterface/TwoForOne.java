package addPromoInterface;

public class TwoForOne implements Promotion{
    @Override
    public int getQuantity(int quantity) {
        return (quantity / 2) + (quantity % 2);
    }
}
