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

    double getChildrensRentalAmount() {
        double rentalAmount = 1.5;
        if (getDaysRented() > 3)
            rentalAmount += (getDaysRented() - 3) * 1.5;
        return rentalAmount;
    }

    double getNewReleaseRentalAmount() {
        return getDaysRented() * 3;
    }

    double getRegularRentalAmount() {
        double rentalAmount = 2;
        if (getDaysRented() > 2)
            rentalAmount += (getDaysRented() - 2) * 1.5;
        return rentalAmount;
    }
}
