public class ChildrensMovie extends Movie {

    private static final double BASE_PRICE = 1.5;

    public ChildrensMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double price(int daysRented) {
        return BASE_PRICE + supplement(daysRented);
    }

    private double supplement(int daysRented) {
        return daysRented > 3
                ? (daysRented - 3) * BASE_PRICE
                : 0;
    }
}
