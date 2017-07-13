public class Movie {
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

    double getRentalAmount(Rental rental) {
        double rentalAmount = 0;

        switch (rental.getMovie().getPriceCode()) {
            case REGULAR:
                rentalAmount += 2;
                if (rental.getDaysRented() > 2) {
                    rentalAmount += (rental.getDaysRented() - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                rentalAmount += rental.getDaysRented() * 3;
                break;
            case CHILDRENS:
                rentalAmount += 1.5;
                if (rental.getDaysRented() > 3) {
                    rentalAmount += (rental.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return rentalAmount;
    }
}