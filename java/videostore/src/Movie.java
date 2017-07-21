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

    public int getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }
}
