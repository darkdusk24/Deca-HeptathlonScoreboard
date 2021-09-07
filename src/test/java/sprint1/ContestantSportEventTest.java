package sprint1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ContestantSportEventTest {
    private String sportEvent;
    private double result;
    private int score;
    private List<Double> results = new ArrayList ();

    @Test
    public void getScoreBlankZeroAndZero() {
        ContestantSportEvent cse = new ContestantSportEvent ("", 0.0, 0);
        int score = 0;
        double result = 0.0;
        String sportEvent = "";
        assertEquals (sportEvent, cse.getSportEvent ());
        assertEquals (result, cse.getResult (), 0);
        assertEquals (score, cse.getScore ());
    }

    @Test
    public void getResultValid() {
        double result = 1.5;
        results = new ArrayList<> ();
        results.add (0, 1.5);
        assertEquals (result, results.get (0), 0);
    }

    @Test
    public void getResultInvalid() {
        results = new ArrayList<> ();
        results.add (0, 1.5);
        double result = 1.4;
        assertNotEquals (result, results.get (0), 0);
    }

    @Test
    public void getSportEventValid() {
        ContestantSportEvent cse = new ContestantSportEvent ("100 m", 0.0, 0);
        String sportEvent = "100 m";
        assertEquals (sportEvent, cse.getSportEvent ());
    }

    @Test
    public void getSportEventInvalid() {
        ContestantSportEvent cse = new ContestantSportEvent ("100 m", 0.0, 0);
        String sportEvent = "200 m";
        assertNotEquals (sportEvent, cse.getSportEvent ());
    }

    @Test
    public void getScoreValid() {
        ContestantSportEvent cse = new ContestantSportEvent ("", 0.0, 4065);
        int score = 4065;
        assertEquals (score, cse.getScore ());
    }

    @Test
    public void getScoreInvalid() {
        ContestantSportEvent cse = new ContestantSportEvent ("", 0.0, 4065);
        int score = 4066;
        assertNotEquals (score, cse.getScore ());
    }
    @Test
    public void testToString() {
        ContestantSportEvent cse = new ContestantSportEvent ("100 m", 0.0, 0);
        String toString = cse.toString ();

        assertTrue (toString.contains (":- Result = " + result));
    }
}