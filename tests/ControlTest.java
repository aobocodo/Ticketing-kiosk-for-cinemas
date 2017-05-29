import org.junit.Test;

import static org.junit.Assert.*;


public class ControlTest {
	@Test
	public void judgeTime() throws Exception {
		Control c = new Control();
		assertFalse(c.judgeTime(18,30,19,07));
	}

}