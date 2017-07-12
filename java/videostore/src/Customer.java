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

    public double totalAmount() {
        return rentals
                .stream()
                .map(Rental::getTotal)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public int frequentRenterPoints() {
        return rentals
                .stream()
                .map(Rental::getFrequentRenterPoints)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public String statement() {
        String statement = "Rental Record for " + name + "\n";

        for (Rental rental : rentals) {
            statement += rental.getStatement();
        }

        statement += "You owed " + totalAmount() + "\n";
        statement += "You earned " + frequentRenterPoints() + " frequent renter points\n";

        return statement;
    }
}