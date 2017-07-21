public abstract class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    protected String title;
    protected int priceCode;

    public Movie(String title, int priceCode) {
        this.priceCode = priceCode;
        this.title = title;
    }

    public String title() {
        return title;
    }

    public int points(int daysRented) {
        return 1;
    }

    public abstract double price(int daysRented);
}
