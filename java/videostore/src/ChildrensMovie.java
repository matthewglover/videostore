public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title) {
        super(title, 1.5, 1.5, 3);
    }

    @Override
    public double price(int daysRented) {
        return basePrice + supplement(daysRented);
    }
}
