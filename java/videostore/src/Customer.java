import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int totalFrequentRenterPoints = 0;
        String result = "Rental Record for " + name + "\n";

        for (Rental rental : rentals) {
            totalFrequentRenterPoints += rental.getFrequentRenterPoints();
            result += rental.getRentalStatement();
            totalAmount += rental.getTotal();

        }

        result += "You owed " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints + " frequent renter points\n";


        return result;
    }

}
