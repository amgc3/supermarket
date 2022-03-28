import java.math.BigDecimal;

public class Price {
    private BigDecimal price;
    String promotion;

    public Price(String price, String promotion) {
        this.price = new BigDecimal(price);
        this.promotion = promotion;
    }

     BigDecimal totalPrice(Integer quantity) {
         System.out.println("promotion " + promotion +  " quantity " + quantity + " price " + price );

         switch (promotion) {
            case "2for1":
                return new BigDecimal(Integer.toString((quantity / 2) + (quantity % 2)))
                        .multiply(this.price);
            case "3for2":
                return new BigDecimal(Integer.toString((quantity / 3) * 2 + (quantity % 3)))
                        .multiply(this.price);
            case "1for1":
            default:
                return new BigDecimal(Integer.toString(quantity)).multiply(this.price);

        }
    }
}
