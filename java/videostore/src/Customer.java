import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private double totalAmount;
    private int frequentRenterPoints;
    private String statement;

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

            double rentalAmount = 0;

            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    rentalAmount += rental.getTotal();
                    break;
                case Movie.NEW_RELEASE:
                    rentalAmount += rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    rentalAmount += 1.5;
                    if (rental.getDaysRented() > 3) {
                        rentalAmount += (rental.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }

            frequentRenterPoints++;

            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            statement += "\t" + rental.getMovie().getTitle() + "\t" + rentalAmount + "\n";
            totalAmount += rentalAmount;
        }

        statement += "You owed " + totalAmount + "\n";
        statement += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return statement;
    }
}