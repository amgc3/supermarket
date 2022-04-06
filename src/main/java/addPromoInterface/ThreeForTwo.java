package addPromoInterface;

public class ThreeForTwo implements Promotion{
    @Override
    public int getQuantity(int quantity) {
        return quantity / 3 * 2 + (quantity % 3);
    }
}
