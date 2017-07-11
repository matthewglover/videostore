public class NewReleaseRental extends AbstractRental {
    public NewReleaseRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    double getTotal() {
        return getDaysRented() * 3;
    }
}
