public abstract class Movie {
    protected final double basePrice;
    protected final double supplementaryRate;
    protected final int supplementThreshold;
    protected String title;

    public Movie(String title, double basePrice) {
        this(title, basePrice, 0, 0);
    }

    public Movie(String title, double basePrice, double supplementaryRate, int supplementThreshold) {
        this.title = title;
        this.basePrice = basePrice;
        this.supplementaryRate = supplementaryRate;
        this.supplementThreshold = supplementThreshold;
    }

    public String title() {
        return title;
    }

    public int points(int daysRented) {
        return 1;
    }

    public abstract double price(int daysRented);

    protected double supplement(int daysRented) {
        return daysRented > supplementThreshold
                ? (daysRented - supplementThreshold) * supplementaryRate
                : 0;
    }
}
