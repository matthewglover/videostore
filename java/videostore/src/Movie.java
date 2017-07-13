public abstract class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract double getRentalAmount(Rental rental);

    public abstract int getFrequentRenterPoints(Rental rental);
}