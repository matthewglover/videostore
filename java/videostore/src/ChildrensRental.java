public class ChildrensRental extends Rental {

    private static final double baseTotal = 1.5;

    public ChildrensRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    double getTotal() {
        return baseTotal + getExtraDaysSupplement();
    }

    private double getExtraDaysSupplement() {
        return getDaysRented() > 3 ? (getDaysRented() - 3) * 1.5 : 0;
    }
}
