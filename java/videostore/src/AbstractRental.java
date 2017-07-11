public abstract class AbstractRental {
    private Movie movie;
    private int daysRented;

    public AbstractRental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    abstract double getTotal();
}
