public class Regular extends Movie {
    public Regular(String title, int priceCode) {
        super(title, priceCode);
    }

    public double getRentalAmount(Rental rental) {
        double rentalAmount = 2;
        if (rental.getDaysRented() > 2) {
            rentalAmount += (rental.getDaysRented() - 2) * 1.5;
        }
        return rentalAmount;
    }

    public int getFrequentRenterPoints(Rental rental) {
        return 1;
    }
}
