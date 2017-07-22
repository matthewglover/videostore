import junit.framework.*;

public class VideoStoreTest extends TestCase
{

	private RentalRecord rentalRecord;
	private Movie newRelease1;
	private Movie newRelease2;
	private Movie childrens;
	private Movie regular1;
	private Movie regular2;
	private Movie regular3;

	public VideoStoreTest(String name) {
		super(name);
	}

	protected void setUp()  {
		rentalRecord = new RentalRecord("Customer");
		newRelease1 = new NewRelease("New Release 1", Movie.NEW_RELEASE);
		newRelease2 = new NewRelease("New Release 2", Movie.NEW_RELEASE);
		childrens = new ChildrensMovie("Childrens Movie", Movie.CHILDRENS);
		regular1 = new RegularMovie("Regular Movie 1", Movie.REGULAR);
		regular2 = new RegularMovie("Regular Movie 2", Movie.REGULAR);
		regular3 = new RegularMovie("Regular Movie 3", Movie.REGULAR);
	}

	public void testNewReleaseStatement() {
		rentalRecord.addRental(new Rental(newRelease1, 3));

		assertEquals("Rental Record for Customer\n" +
				"\tNew Release 1\t9.0\n" +
				"You owed 9.0\n" +
				"You earned 2 frequent renter points\n",
				rentalRecord.statement());
	}

	public void testNewReleaseStatements() {
		rentalRecord.addRental(new Rental(newRelease1, 3));
		rentalRecord.addRental(new Rental(newRelease2, 3));

		assertEquals("Rental Record for Customer\n" +
				"\tNew Release 1\t9.0\n" +
				"\tNew Release 2\t9.0\n" +
				"You owed 18.0\n" +
				"You earned 4 frequent renter points\n",
				rentalRecord.statement());
	}

	public void testChildrensStatement() {
		rentalRecord.addRental(new Rental(childrens, 3));

		assertEquals("Rental Record for Customer\n" +
				"\tChildrens Movie\t1.5\n" +
				"You owed 1.5\n" +
				"You earned 1 frequent renter points\n",
				rentalRecord.statement());
	}

	public void testRegularStatements() {
		rentalRecord.addRental(new Rental(regular1, 1));
		rentalRecord.addRental(new Rental(regular2, 2));
		rentalRecord.addRental(new Rental(regular3, 3));

		assertEquals("Rental Record for Customer\n" +
				"\tRegular Movie 1\t2.0\n" +
				"\tRegular Movie 2\t2.0\n" +
				"\tRegular Movie 3\t3.5\n" +
				"You owed 7.5\n" +
				"You earned 3 frequent renter points\n",
				rentalRecord.statement());
	}
}
