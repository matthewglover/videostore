public class RegularRental extends Rental {
    private static final double baseTotal = 2;

    public RegularRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    double getTotal() {
        return baseTotal + getExtraDaysSupplement();
    }

    private double getExtraDaysSupplement() {
        return (getDaysRented() - 2) * 1.5;
    }
}
