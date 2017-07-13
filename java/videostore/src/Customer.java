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
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.movie.getRentalAmount(rental);
        }
        return totalAmount;
    }

    public int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.movie.getFrequentRenterPoints(rental);
        }
        return frequentRenterPoints;
    }

    public String statement() {
        String statement = "Rental Record for " + name + "\n";

        for (Rental rental : rentals) {
            statement += "\t" + rental.getMovie().getTitle() + "\t" + rental.movie.getRentalAmount(rental) + "\n";
        }

        statement += "You owed " + totalAmount() + "\n";
        statement += "You earned " + frequentRenterPoints() + " frequent renter points\n";

        return statement;
    }

}