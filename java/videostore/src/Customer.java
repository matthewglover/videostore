import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private double totalAmount;
    private int frequentRenterPoints;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public double totalAmount() {
        return totalAmount;
    }

    public int frequentRenterPoints() {
        return frequentRenterPoints;
    }

    public String statement() {
        totalAmount = 0;
        frequentRenterPoints = 0;

        String statement = "Rental Record for " + name + "\n";

        for (Rental rental : rentals) {

            double rentalAmount = rental.movie.getRentalAmount(rental);

            frequentRenterPoints += rental.movie.getFrequentRenterPoints(rental);

            statement += "\t" + rental.getMovie().getTitle() + "\t" + rentalAmount + "\n";
            totalAmount += rentalAmount;
        }

        statement += "You owed " + totalAmount + "\n";
        statement += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return statement;
    }

}