public class Regular extends Movie {
    public Regular(String title, int priceCode) {
        super(title, priceCode);
    }

    public double getRentalAmount(Rental rental) {
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
