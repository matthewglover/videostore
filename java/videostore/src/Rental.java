public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 1;

        if (isBonusFrequentRenterPoints())
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private boolean isBonusFrequentRenterPoints() {
        return getMovie().getPriceCode() == Movie.NEW_RELEASE
                && getDaysRented() > 1;
    }
}
