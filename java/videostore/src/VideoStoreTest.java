import junit.framework.*;

public class VideoStoreTest extends TestCase
{

	private Movie newRelease1;
	private Movie newRelease2;
	private Movie childrens;
	private Movie regular1;
	private Movie regular2;
	private Movie regular3;

	public VideoStoreTest (String name) {
		super (name);
	}

	protected void setUp ()  {
		rentalRecord = new RentalRecord("Fred");
		newRelease1 = new NewRelease("The Cell", Movie.NEW_RELEASE);
		newRelease2 = new NewRelease("The Tigger Movie", Movie.NEW_RELEASE);
		childrens = new ChildrensMovie("The Tigger Movie", Movie.CHILDRENS);
		regular1 = new RegularMovie("Plan 9 from Outer Space", Movie.REGULAR);
		regular2 = new RegularMovie("8 1/2", Movie.REGULAR);
		regular3 = new RegularMovie("Eraserhead", Movie.REGULAR);
	}

	public void testSingleNewReleaseStatement () {
		rentalRecord.addRental (new Rental (newRelease1, 3));
		assertEquals ("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", rentalRecord.statement ());
	}

	public void testDualNewReleaseStatement () {
		rentalRecord.addRental (new Rental (newRelease1, 3));
		rentalRecord.addRental (new Rental (newRelease2, 3));
		assertEquals ("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", rentalRecord.statement ());
	}

	public void testSingleChildrensStatement () {
		rentalRecord.addRental (new Rental (childrens, 3));
		assertEquals ("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", rentalRecord.statement ());
	}

	public void testMultipleRegularStatement () {
		rentalRecord.addRental (new Rental (regular1, 1));
		rentalRecord.addRental (new Rental (regular2, 2));
		rentalRecord.addRental (new Rental (regular3, 3));

		assertEquals ("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", rentalRecord.statement ());
	}

	private RentalRecord rentalRecord;
}
