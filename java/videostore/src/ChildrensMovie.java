public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double price(int daysRented) {
        return 1.5 + supplement(daysRented);
    }

    private double supplement(int daysRented) {
        double rentalAmount = 0;
        if (daysRented > 3) {
            rentalAmount += (daysRented - 3) * 1.5;
        }
        return rentalAmount;
    }
}
