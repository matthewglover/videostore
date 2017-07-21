import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }


    public String statement() {
        double totalAmount = 0;
        int totalFrequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            double rentalAmount = 0;

            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    rentalAmount = getRegularRentalAmount(rental);
                    break;
                case Movie.NEW_RELEASE:
                    rentalAmount = getNewReleaseRentalAmount(rental);
                    break;
                case Movie.CHILDRENS:
                    rentalAmount = getChildrensRentalAmount(rental);
                    break;
            }

            totalFrequentRenterPoints += getFrequentRenterPoints(rental);

            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + rentalAmount + "\n";
            totalAmount += rentalAmount;

        }

        result += "You owed " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints + " frequent renter points\n";


        return result;
    }

    private int getFrequentRenterPoints(Rental rental) {
        int frequentRenterPoints = 1;

        if (isBonusFrequentRenterPoints(rental))
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private double getChildrensRentalAmount(Rental rental) {
        double rentalAmount = 1.5;
        if (rental.getDaysRented() > 3)
            rentalAmount += (rental.getDaysRented() - 3) * 1.5;
        return rentalAmount;
    }

    private double getNewReleaseRentalAmount(Rental rental) {
        return rental.getDaysRented() * 3;
    }

    private double getRegularRentalAmount(Rental rental) {
        double rentalAmount = 2;
        if (rental.getDaysRented() > 2)
            rentalAmount += (rental.getDaysRented() - 2) * 1.5;
        return rentalAmount;
    }

    private boolean isBonusFrequentRenterPoints(Rental rental) {
        return rental.getMovie().getPriceCode() == Movie.NEW_RELEASE
                && rental.getDaysRented() > 1;
    }
}
