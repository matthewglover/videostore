import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentalRecord {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public RentalRecord(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        return "Rental Record for " + name + "\n" +
                rentalStatements() + "\n" +
                "You owed " + totalPrice() + "\n" +
                "You earned " + totalPoints() + " frequent renter points\n";
    }

    private String rentalStatements() {
        return rentals
                .stream()
                .map(Rental::statement)
                .collect(Collectors.joining("\n"));
    }

    private double totalPrice() {
        return rentals
                .stream()
                .mapToDouble(Rental::price)
                .sum();
    }

    private int totalPoints() {
        return rentals
                .stream()
                .mapToInt(Rental::points)
                .sum();
    }
}
