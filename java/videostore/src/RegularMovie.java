public class RegularMovie extends Movie {

    private static final int BASE_PRICE = 2;
    private static final double SUPPLEMENTARY_RATE = 1.5;
    private static final int SUPPLEMENT_THRESHOLD = 2;

    public RegularMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double price(int daysRented) {
        return BASE_PRICE + supplement(daysRented);
    }

    private double supplement(int daysRented) {
        return daysRented > SUPPLEMENT_THRESHOLD
                ? (daysRented - SUPPLEMENT_THRESHOLD) * SUPPLEMENTARY_RATE
                : 0;
    }
}
