public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int daysRented() {
        return daysRented;
    }

    public Movie movie() {
        return movie;
    }

    public int points() {
        int frequentRenterPoints = 1;

        if (isBonusFrequentRenterPoints())
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public double price() {
        double cost = 0;
        switch (movie().getPriceCode()) {
            case Movie.REGULAR:
                cost = getRegularRentalAmount();
                break;
            case Movie.NEW_RELEASE:
                cost = getNewReleaseRentalAmount();
                break;
            case Movie.CHILDRENS:
                cost = getChildrensRentalAmount();
                break;
        }
        return cost;
    }

    public String statement() {
        return "\t" + movie().getTitle() + "\t"
                + price();
    }

    private boolean isBonusFrequentRenterPoints() {
        return movie().getPriceCode() == Movie.NEW_RELEASE
                && daysRented() > 1;
    }

    private double getChildrensRentalAmount() {
        double rentalAmount = 1.5;
        if (daysRented() > 3)
            rentalAmount += (daysRented() - 3) * 1.5;
        return rentalAmount;
    }

    private double getNewReleaseRentalAmount() {
        return daysRented() * 3;
    }

    private double getRegularRentalAmount() {
        double rentalAmount = 2;
        if (daysRented() > 2)
            rentalAmount += (daysRented() - 2) * 1.5;
        return rentalAmount;
    }
}
