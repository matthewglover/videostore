public class NewRelease extends Movie {
    public NewRelease(String title, int priceCode) {
        super(title, priceCode);
    }

    public double getRentalAmount(Rental rental) {
        return (double) (rental.getDaysRented() * 3);
    }
}
