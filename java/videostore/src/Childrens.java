public class Childrens extends Movie {
    public Childrens(String title, int priceCode) {
        super(title, priceCode);
    }

    public double getRentalAmount(Rental rental) {
        double rentalAmount = 0;

        rentalAmount += 1.5;
        if (rental.getDaysRented() > 3) {
            rentalAmount += (rental.getDaysRented() - 3) * 1.5;
        }
        return rentalAmount;
    }
}
