public class NewRelease extends Movie {
    public NewRelease(String title, int priceCode) {
        super(title, priceCode);
    }

    public double getRentalAmount(Rental rental) {
        double rentalAmount = 0;

        rentalAmount += rental.getDaysRented() * 3;
        return rentalAmount;
    }
}
