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

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String statement = "Rental Record for " + name + "\n";

        for (Rental rental : rentals) {

            double rentalAmount = 0;

            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    rentalAmount += 2;
                    if (rental.getDaysRented() > 2) {
                        rentalAmount += (rental.getDaysRented() - 2) * 1.5;
                    }
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