public class NewRelease extends Movie {
    public NewRelease(String title) {
        super(title, 3);
    }

    @Override
    public int points(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }

    @Override
    public double price(int daysRented) {
        return daysRented * basePrice;
    }
}
