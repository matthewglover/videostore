import junit.framework.*;

public class VideoStoreTest extends TestCase {

    private Customer customer;
    private Movie newRelease1;
    private Movie newRelease2;
    private Movie childrens;
    private Movie regular1;
    private Movie regular2;

    private Movie regular3;

    public VideoStoreTest(String name) {
        super(name);
    }

    protected void setUp() {
        customer = new Customer("Fred");
        newRelease1 = new Movie("New Release", Movie.NEW_RELEASE);
        newRelease2 = new Movie("New Release 2", Movie.NEW_RELEASE);
        childrens = new Movie("Childrens", Movie.CHILDRENS);
        regular1 = new Movie("Regular 1", Movie.REGULAR);
        regular2 = new Movie("Regular 2", Movie.REGULAR);
        regular3 = new Movie("Regular", Movie.REGULAR);
    }

    public void testNewReleaseRentalTotal() {
        NewReleaseRental rental = new NewReleaseRental(newRelease1, 1);
        assertEquals(3.0, rental.getTotal());
    }

    public void testChildrensRentalTotalOfThreeDays() {
        ChildrensRental rental = new ChildrensRental(childrens, 3);
        assertEquals(1.5, rental.getTotal());
    }

    public void testChildrensRentalTotalOfMoreThanThreeDays() throws Exception {
        ChildrensRental rental = new ChildrensRental(childrens, 9);
        assertEquals(10.5, rental.getTotal());
    }

    public void testRegularRentalTotalOfTwoDays() throws Exception {
        RegularRental rental = new RegularRental(regular1, 2);
        assertEquals(2.0, rental.getTotal());
    }

    public void testRegularRentalTotalOfMoreThanTwoDays() {
        RegularRental rental = new RegularRental(regular1, 4);
        assertEquals(5.0, rental.getTotal());
    }

    public void testTotalsForNewRelease() {
        customer.addRental(new Rental(newRelease1, 3));
        customer.statement();
        assertEquals(9.0, customer.totalAmount());
        assertEquals(2, customer.frequentRenterPoints());
    }

    public void testSingleNewReleaseStatement() {
        customer.addRental(new Rental(newRelease1, 3));
        assertEquals(
                "Rental Record for Fred\n" +
                        "\tNew Release\t9.0\n" +
                        "You owed 9.0\n" +
                        "You earned 2 frequent renter points\n",
                customer.statement());
    }

    public void testMultipleNewReleasesStatement() {
        customer.addRental(new Rental(newRelease1, 3));
        customer.addRental(new Rental(newRelease2, 3));
        assertEquals(
                "Rental Record for Fred\n" +
                        "\tNew Release\t9.0\n" +
                        "\tNew Release 2\t9.0\n" +
                        "You owed 18.0\n" +
                        "You earned 4 frequent renter points\n",
                customer.statement());
    }

    public void testSingleChildrensStatement() {
        customer.addRental(new Rental(childrens, 3));
        assertEquals(
                "Rental Record for Fred\n" +
                        "\tChildrens\t1.5\n" +
                        "You owed 1.5\n" +
                        "You earned 1 frequent renter points\n",
                customer.statement());
    }

    public void testMultipleRegularsStatement() {
        customer.addRental(new Rental(regular1, 1));
        customer.addRental(new Rental(regular2, 2));
        customer.addRental(new Rental(regular3, 3));

        assertEquals(
                "Rental Record for Fred\n" +
                        "\tRegular 1\t2.0\n" +
                        "\tRegular 2\t2.0\n" +
                        "\tRegular\t3.5\n" +
                        "You owed 7.5\n" +
                        "You earned 3 frequent renter points\n",
                customer.statement());
    }
}