package sprint1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCompetitorScore {
	
	CompetitorsScore compSc;
	String champion= "Hugo Wieslander";
	
	@Before
	public void setUp() throws Exception {
		compSc = new CompetitorsScore(champion);
	}

	@After
	public void tearDown() throws Exception {
		compSc = null;
	}
	
	@Test
	public void testGetName() {
		assertEquals(champion, compSc.getName());
	}

	@Test
	public void testGetSportsEvent() {
		String event = ("110mH");
		compSc.setSportsEvent(event);
		assertEquals(event, compSc.getSportsEvent());
	}

	@Test
	public void testGetScore() {
		Double score = 900.0;
		compSc.setScore(score);
		assertEquals(score, compSc.getScore(), 0);
	}

}
