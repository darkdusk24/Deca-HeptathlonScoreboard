package sprint1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RegisterContestantWithScoreTest {
    private String name;
    private int number;
    private int place;
    private String country;
    private ScoreCalculator calc = new ScoreCalculator();
    private List<ContestantSportEvent> sportEvents = new ArrayList<> ();
    Contestant contestant;

    {
        contestant = new Contestant ("", 0, "");
    }
    @Test
    public void registerContestantWithScoreSingleEvent() {

        contestant.setName ("Carl Lewis");
        contestant.setNumber (155);
        contestant.setCountry ("USA");

        ContestantSportEvent underTest = new ContestantSportEvent ("1500 m",
                25.0, 3114);
        sportEvents.add (0, underTest);

        String scores = "";
        int totalScore = 0;
        for (ContestantSportEvent sportEvent : sportEvents) {
            scores += sportEvent.toString();
            totalScore = calc.totalScoreCalculation(sportEvents);
        }

        assertEquals(totalScore, 3114);
       assertEquals (contestant.getName (), "Carl Lewis");
    }

    @Test
    public void registerContestantWithScoreMultipleEvents() {

        contestant.setName ("Carl Lewis");
        contestant.setNumber (155);
        contestant.setCountry ("USA");

        ContestantSportEvent underTest = new ContestantSportEvent ("100 m", 8.5, 1496);
        sportEvents.add (0, underTest);
        ContestantSportEvent underTest1 = new ContestantSportEvent ("Long jump", 1000.0, 1606);
        sportEvents.add (1, underTest1);
        ContestantSportEvent underTest2 = new ContestantSportEvent ("Shot put", 30.0, 1731);
        sportEvents.add (2, underTest2);
        ContestantSportEvent underTest3 = new ContestantSportEvent ("High jump", 350.0, 2463);
        sportEvents.add (3, underTest3);

        String scores = "";
        int totalScore = 0;
        for (ContestantSportEvent sportEvent : sportEvents) {
            scores += sportEvent.toString();
            totalScore = calc.totalScoreCalculation(sportEvents);
        }
        assertEquals(totalScore, 7296);
        assertEquals (contestant.getName (), "Carl Lewis");
    }

}
