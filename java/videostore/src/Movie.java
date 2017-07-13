public abstract class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public abstract double getRentalAmount(Rental rental);

    int getFrequentRenterPoints(Rental rental) {
        int frequentRenterPoints = 1;

        if (rental.getMovie().getPriceCode() == NEW_RELEASE && rental.getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}