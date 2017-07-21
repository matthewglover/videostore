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

    public double getTotal() {
        double rentalAmount = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount = getRegularRentalAmount();
                break;
            case Movie.NEW_RELEASE:
                rentalAmount = getNewReleaseRentalAmount();
                break;
            case Movie.CHILDRENS:
                rentalAmount = getChildrensRentalAmount();
                break;
        }
        return rentalAmount;
    }

    public String getRentalStatement() {
        return "\t" + getMovie().getTitle() + "\t"
                + getTotal() + "\n";
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
