public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int points() {
        int frequentRenterPoints = 1;

        if (isBonusFrequentRenterPoints())
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public double price() {
        return movie.price(daysRented);
    }

    public String statement() {
        return "\t" + movie.title() + "\t" + price();
    }

    private boolean isBonusFrequentRenterPoints() {
        return movie.priceCode() == Movie.NEW_RELEASE
                && daysRented > 1;
    }
}
