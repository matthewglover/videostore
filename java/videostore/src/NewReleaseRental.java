public class NewReleaseRental extends Rental {
    public NewReleaseRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    double getTotal() {
        return getDaysRented() * 3;
    }
}
