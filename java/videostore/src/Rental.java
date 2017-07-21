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

    public int getPoints() {
        int frequentRenterPoints = 1;

        if (isBonusFrequentRenterPoints())
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public double getPrice() {
        double cost = 0;
        switch (getMovie().getPriceCode()) {
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

    public String getStatement() {
        return "\t" + getMovie().getTitle() + "\t"
                + getPrice() + "\n";
    }

    private boolean isBonusFrequentRenterPoints() {
        return getMovie().getPriceCode() == Movie.NEW_RELEASE
                && getDaysRented() > 1;
    }

    private double getChildrensRentalAmount() {
        double rentalAmount = 1.5;
        if (getDaysRented() > 3)
            rentalAmount += (getDaysRented() - 3) * 1.5;
        return rentalAmount;
    }

    private double getNewReleaseRentalAmount() {
        return getDaysRented() * 3;
    }

    private double getRegularRentalAmount() {
        double rentalAmount = 2;
        if (getDaysRented() > 2)
            rentalAmount += (getDaysRented() - 2) * 1.5;
        return rentalAmount;
    }
}
