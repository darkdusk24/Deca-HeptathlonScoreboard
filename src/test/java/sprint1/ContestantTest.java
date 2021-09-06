package sprint1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ContestantTest {
    private List<ContestantSportEvent> sportEvents = new ArrayList<> ();
    private Contestant contestant;
    private ContestantSportEvent event;
    @Before
    public void setUp() {
        contestant = new Contestant ("", 0, "");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void setNameNumberAndCountryEmpty() {
        assertNotEquals ("Calvin Hall", contestant.getName ());
        assertNotEquals (187, contestant.getNumber ());
        assertNotEquals ("USA", contestant.getCountry ());
    }

    @Test
    public void setNameNumberAndCountryValid() {
        contestant = new Contestant ("Calvin Hall", 187, "USA");
        assertEquals ("Calvin Hall", contestant.getName ());
        assertEquals (187, contestant.getNumber ());
        assertEquals ("USA", contestant.getCountry ());
    }

    @Test
    public void setNameNumberAndCountryInValid() {
        contestant = new Contestant ("Calvin Hall", 187, "USA");
        assertNotEquals ("Calvin Fall", contestant.getName ());
        assertNotEquals (186, contestant.getNumber ());
        assertNotEquals ("USB", contestant.getCountry ());
    }

    @Test
    public void setName() {
        contestant.setName ("Calvin");
        String expected = contestant.getName ();
        assertEquals (expected, "Calvin");
    }

    @Test
    public void getNameBlankInput() {
        contestant.setName ("");
        String expected = contestant.getName ();
        assertNotEquals (expected, "Calvin");
    }

    @Test
    public void setNumber() {
        contestant.setNumber (187);
        int expected = contestant.getNumber ();
        assertEquals (expected, 187);
    }

    @Test
    public void getNumberZeroInput() {
        contestant.setNumber (0);
        int expected = contestant.getNumber ();
        assertNotEquals (expected, 187);
    }

    @Test
    public void getCountryBlankInput() {
        contestant.setCountry ("");
        String expected = contestant.getCountry ();
        assertNotEquals (expected, "USA");
    }

    @Test
    public void setCountry() {
        contestant.setCountry ("USA");
        String expected = contestant.getCountry ();
        assertEquals (expected, "USA");
    }

    @Test
    public void getSportEvent() {
        sportEvents = new ArrayList<> ();
        sportEvents.add (new ContestantSportEvent ("Long jump", 35.0, 2051));
        String event = "Long jump";
        int num = 0;

        while(num < sportEvents.size()) {
            if(sportEvents.get(num).getSportEvent().equalsIgnoreCase(event)) {
                break;
            } else {
                num++;
            }
        }
        assertTrue (sportEvents.get (num).getSportEvent ().equalsIgnoreCase ("Long jump"));
    }

    @Test
    public void getSportEvents() {
        sportEvents = new ArrayList<> ();
        sportEvents.add (new ContestantSportEvent ("100 m", 1.2, 4199));

        ContestantSportEvent sportEvent = sportEvents.get (0);
        assertTrue (sportEvent.toString ().contains ("\n100 M:- Result = 1.2, Score = 4199"));

    }

    @Test
    public void testToString() {
        String toString = contestant.toString ();
        assertTrue (toString.contains ("\nTOTAL SCORE:- 0"));
    }

    @Test
    public void testAddSportEvent() {

        ContestantSportEvent event = new ContestantSportEvent("Long jump", 35.0,2051);
        this.sportEvents.add(event);
        assertTrue (sportEvents.toString ().contains ("\nLONG JUMP:- Result = 35.0, Score = 2051"));
    }
}