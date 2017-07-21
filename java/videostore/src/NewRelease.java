public class NewRelease extends Movie {
    public NewRelease(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    double price(int daysRented) {
        return daysRented * 3;
    }
}
