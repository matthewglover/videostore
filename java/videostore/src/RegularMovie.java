public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title, 2, 1.5, 2);
    }

    @Override
    public double price(int daysRented) {
        return basePrice + supplement(daysRented);
    }

}
