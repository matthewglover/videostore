public class NewRelease extends Movie {
    public NewRelease(String title, int priceCode) {
        super(title);
    }

    public double getRentalAmount(Rental rental) {
        return (double) (rental.getDaysRented() * 3);
    }

    public int getFrequentRenterPoints(Rental rental) {
        int frequentRenterPoints = 1;

        if (rental.getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}
