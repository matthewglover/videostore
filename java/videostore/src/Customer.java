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
                    rentalAmount = rental.getRegularRentalAmount();
                    break;
                case Movie.NEW_RELEASE:
                    rentalAmount = rental.getNewReleaseRentalAmount();
                    break;
                case Movie.CHILDRENS:
                    rentalAmount = rental.getChildrensRentalAmount();
                    break;
            }

            totalFrequentRenterPoints += rental.getFrequentRenterPoints();

            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + rentalAmount + "\n";
            totalAmount += rentalAmount;

        }

        result += "You owed " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints + " frequent renter points\n";


        return result;
    }

}
