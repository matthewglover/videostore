public class RegularMovie extends Movie {
    public RegularMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double price(int daysRented) {
        double rentalAmount = 2;
        if (daysRented > 2) {
            rentalAmount += (daysRented - 2) * 1.5;
        }
        return rentalAmount;
    }
}
