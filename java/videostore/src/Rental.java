public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int points() {
        return movie.points(daysRented);
    }

    public double price() {
        return movie.price(daysRented);
    }

    public String statement() {
        return "\t" + movie.title() + "\t" + price();
    }
}
