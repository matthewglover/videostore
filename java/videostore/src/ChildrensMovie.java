public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    double price(int daysRented) {
        double rentalAmount = 1.5;
        if (daysRented > 3)
            rentalAmount += (daysRented - 3) * 1.5;
        return rentalAmount;
    }
}
