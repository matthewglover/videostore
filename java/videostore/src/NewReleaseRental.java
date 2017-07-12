public class NewReleaseRental extends Rental {
    public NewReleaseRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    double getTotal() {
        return getDaysRented() * 3;
    }

    @Override
    public int getFrequentRenterPoints() {
        return super.getFrequentRenterPoints() + getRenterPointSupplement();
    }

    private int getRenterPointSupplement() {
        return getDaysRented() > 1 ? 1 : 0;
    }
}
