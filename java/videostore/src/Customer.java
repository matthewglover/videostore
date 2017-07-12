import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public String rentalStatements() {
        return rentals
                .stream()
                .map(Rental::getStatement)
                .collect(Collectors.joining(""));
    }

    public String statement() {
        String statement = "Rental Record for " + name + "\n";
        statement += rentalStatements();
        statement += "You owed " + totalAmount() + "\n";
        statement += "You earned " + frequentRenterPoints() + " frequent renter points\n";

        return statement;
    }
}