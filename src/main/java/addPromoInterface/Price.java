package addPromoInterface;

import java.math.BigDecimal;

public class Price {
    private final BigDecimal price;
    private final Promotion promotion;

    public Price(String price, Promotion promotion) {
        this.price = new BigDecimal(price);
        this.promotion = promotion;
    }

    public BigDecimal totalPrice(int quantity) {
        System.out.println("promotion " + promotion +  " quantity " + quantity + " price " + price );
        return new BigDecimal(Integer.toString(promotion.getQuantity(quantity))).multiply(this.price);
    }
}
