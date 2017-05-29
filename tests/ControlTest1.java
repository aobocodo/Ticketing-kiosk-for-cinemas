import org.junit.Test;

import static org.junit.Assert.*;


public class ControlTest1 {
	private Control c = new Control();
	@Test
	public void getSeatWidth() throws Exception {
		c.readSeatinfo();
		assertEquals(String.valueOf(c.getSeatWidth("BEAUTY AND THE BEAST","1","10:00")),"9");
	}

	@Test
	public void getSeatHeight() throws Exception {
		c.readSeatinfo();
		assertEquals(String.valueOf(c.getSeatHeight("BEAUTY AND THE BEAST","1","10:00")),"4");
	}

	@Test
	public void getRowSeat() throws Exception {
		c.readSeatinfo();
		assertEquals(String.valueOf(c.getRowSeat("BEAUTY AND THE BEAST","1","10:00")),"8");
	}

}