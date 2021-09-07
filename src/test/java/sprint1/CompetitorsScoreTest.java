package sprint1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CompetitorsScoreTest {

    private List<ContestantSportEvent> sportEvents = new ArrayList<> ();
    ContestantSportEvent cse = new ContestantSportEvent ("", 0.0, 0);
    Contestant competitor = new Contestant ("Calvin" , 187, "USA");
    private ScoreCalculator calc = new ScoreCalculator();

    @Test
    public void updateName() {
        //CompetitorsScore competitorsScore = new CompetitorsScore (new );
        String name = "Calvin";
        this.competitor.setName (name);

        String expected = "Calvin";
        //Then
        assertEquals (expected, competitor.getName ());

    }

    @Test
    public void getName() {
        String name = "Calvin";
        // Given
        this.competitor.setName (name);
        //When
        String expected = "";
        //Then
        assertNotEquals (expected, competitor.getName ());

    }

    @Test
    public void getSportsEvent() {
        List<ContestantSportEvent> sportEvents = new ArrayList<> ();
        sportEvents.add (new ContestantSportEvent ("400 m", 5.7, 3928));
        sportEvents.add (new ContestantSportEvent ("110 m hurdles",9.5,1638));
        sportEvents.add (new ContestantSportEvent ("Discus throw",15.0,180));
        int expected = sportEvents.size ();
        assertEquals (expected, 3);

    }

    @Test
    public void getTotalScore() {
       //Given
        int scores = 0;
        double totalScore = 0.0;
        sportEvents = new ArrayList<> ();
        sportEvents.add (new ContestantSportEvent ("100 m",12.0,651));
        sportEvents.add (new ContestantSportEvent ("Long jump", 650.0, 697));
        sportEvents.add (new ContestantSportEvent ("Shot put", 15.0, 790));

        //When
        totalScore = calc.totalScoreCalculation(sportEvents);
        //Then
        assertTrue (totalScore == 2138);

    }

    @Test
    public void testToString() {

        String toString = competitor.toString ();
        assertTrue (toString.contains ("Calvin (187) USA: \nTOTAL SCORE:- 0"));

    }
}