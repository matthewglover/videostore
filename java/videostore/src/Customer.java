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
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            double rentalAmount = 0;

            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    rentalAmount = getRegularRentalAmount(rental);
                    break;
                case Movie.NEW_RELEASE:
                    rentalAmount = getNewReleaseRentalAmount(rental);
                    break;
                case Movie.CHILDRENS:
                    rentalAmount = getChildrensRentalAmount(rental);
                    break;
            }

            frequentRenterPoints++;

            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE
                    && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(rentalAmount) + "\n";
            totalAmount += rentalAmount;

        }

        result += "You owed " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";


        return result;
    }

    private double getChildrensRentalAmount(Rental rental) {
        double rentalAmount = 1.5;
        if (rental.getDaysRented() > 3)
            rentalAmount += (rental.getDaysRented() - 3) * 1.5;
        return rentalAmount;
    }

    private double getNewReleaseRentalAmount(Rental rental) {
        return rental.getDaysRented() * 3;
    }

    private double getRegularRentalAmount(Rental rental) {
        double rentalAmount = 2;
        if (rental.getDaysRented() > 2)
            rentalAmount += (rental.getDaysRented() - 2) * 1.5;
        return rentalAmount;
    }
}
