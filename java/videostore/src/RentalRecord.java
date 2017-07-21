import java.util.ArrayList;
import java.util.List;

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
        double totalPrice = 0;
        int totalPoints = 0;
        String statement = "Rental Record for " + name + "\n";

        for (Rental rental : rentals) {
            totalPoints += rental.getPoints();
            totalPrice += rental.getPrice();
            statement += rental.getStatement();

        }

        statement += "You owed " + totalPrice + "\n";
        statement += "You earned " + totalPoints + " frequent renter points\n";

        return statement;
    }

}
