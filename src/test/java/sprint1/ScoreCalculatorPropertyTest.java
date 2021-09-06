package sprint1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScoreCalculatorPropertyTest {
    private double result;
    private List<ContestantSportEvent> sportEvents;
    private int score;

    @Test
    public void testEventScoreCalculationZeroResults () {
        ScoreCalculator sc = new ScoreCalculator();
        assertEquals (sc.eventScoreCalculation ("Decathlon", "100 m", 0.0), 4758);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "Long jump", 0), 0);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "Long jump", 0), 0);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "Shot put", 0), 0);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "Shot put", 0), 0);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "High jump", 0), 0);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "High jump", 0), 0);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "400 m", 0.0), 4475);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "110 m hurdles", 0.0), 3568);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "Discus throw", 0), 0);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "Pole vault", 0), 0);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "Javelin throw", 0), 0);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "Javelin throw", 0), 0);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "1500 m", 0), 3438);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "200 m", 0.0), 4421);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "800 m", 0), 3715);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "100 m hurdles", 0.0), 3827);
    }

    @Test
    public void testEventScoreCalculationValid () {
        ScoreCalculator sc = new ScoreCalculator();
        assertEquals (sc.eventScoreCalculation ("Decathlon", "100 m", 1.2), 4199);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "Long jump", 850), 1191);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "Long jump", 495), 546);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "Shot put", 35), 2051);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "Shot put", 30), 1887);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "High jump", 365), 2656);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "High jump", 210), 1373);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "400 m", 5.7), 3928);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "110 m hurdles", 9.5), 1638);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "Discus throw", 15), 180);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "Pole vault", 350), 482);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "Javelin throw", 35), 370);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "Javelin throw", 25), 382);
        assertEquals (sc.eventScoreCalculation ("Decathlon", "1500 m", 240), 953);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "200 m", 3.6), 3766);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "800 m", 150), 693);
        assertEquals (sc.eventScoreCalculation ("Heptathlon", "100 m hurdles", 12.8), 1155);
    }

    @Test
    public void testEventScoreCalculationInvalid () {
        ScoreCalculator sc = new ScoreCalculator();
        Assert.assertNotSame (sc.eventScoreCalculation ("Decathlon", "---", 1.6), 4199);
        Assert.assertNotSame (sc.eventScoreCalculation ("---", "Long jump", 500), 1191);
        Assert.assertNotSame (sc.eventScoreCalculation ("Heptathlon", "Long jump", 600), 546);
        Assert.assertNotSame (sc.eventScoreCalculation ("---", "Shot put", 55), 2051);
        Assert.assertNotSame (sc.eventScoreCalculation ("Heptathlon", "---", 0), 1887);
        Assert.assertNotSame (sc.eventScoreCalculation ("---", "High jump", 1000), 2656);
        Assert.assertNotSame (sc.eventScoreCalculation ("Heptathlon", "High jump", 0), 1373);
        Assert.assertNotSame (sc.eventScoreCalculation ("Decathlon", "400 m", 1.1), 3928);
        Assert.assertNotSame (sc.eventScoreCalculation ("Decathlon", "110 m hurdles", 75), 1638);
        Assert.assertNotSame (sc.eventScoreCalculation ("Decathlon", "Discus throw", 700), 180);
        Assert.assertNotSame (sc.eventScoreCalculation ("Decathlon", "Pole vault", -1), 482);
        Assert.assertNotSame (sc.eventScoreCalculation ("Decathlon", "Javelin throw", 300), 370);
        Assert.assertNotSame (sc.eventScoreCalculation ("Heptathlon", "Javelin throw", -10), 382);
        Assert.assertNotSame (sc.eventScoreCalculation ("Decathlon", "1500 m", 800), 953);
        Assert.assertNotSame (sc.eventScoreCalculation ("Heptathlon", "200 m", 1.0), 3766);
        Assert.assertNotSame (sc.eventScoreCalculation ("Heptathlon", "800 m", 50), 693);
        Assert.assertNotSame (sc.eventScoreCalculation ("Heptathlon", "100 m hurdles", 120.8), 1155);
    }

    @Test
    public void testTotalScoreCalculationDeca() {

        List<ContestantSportEvent> events = new ArrayList<> ();
        events.add (new ContestantSportEvent ("100 m",1.2,4199));
        events.add (new ContestantSportEvent ("Long jump",850.0,1191));
        events.add (new ContestantSportEvent ("Shot put",35.0,2051));
        events.add (new ContestantSportEvent ("High jump",365.0,2656));
        events.add (new ContestantSportEvent ("400 m",5.7,3928));
        events.add (new ContestantSportEvent ("110 m hurdles",9.5,1638));
        events.add (new ContestantSportEvent ("Discus throw",15.0,180));
        events.add (new ContestantSportEvent ("Pole vault",350.0,482));
        events.add (new ContestantSportEvent ("Javelin throw",35.0,370));
        events.add (new ContestantSportEvent ("1500 m",240.0,953));

        int totalScore = 0;
        if(!events.isEmpty()) {
            for (int i = 0; i < events.size (); i++) {
                totalScore += events.get (i).getScore ();
            }
        }

        assertEquals (totalScore, 17648);
    }

    @Test
    public void testTotalScoreCalculationHepta() {

        List<ContestantSportEvent> events = new ArrayList<> ();

        events.add (new ContestantSportEvent ("100 m hurdles",12.8,1155));
        events.add (new ContestantSportEvent ("High jump",210.0,1373));
        events.add (new ContestantSportEvent ("Shot put",30.0,1887));
        events.add (new ContestantSportEvent ("200 m",3.6,3766));
        events.add (new ContestantSportEvent ("Long jump",495.0,546));
        events.add (new ContestantSportEvent ("Javelin throw",25.0,382));
        events.add (new ContestantSportEvent ("800 m",150.0,693));

        int totalScore = 0;
        if(!events.isEmpty()) {
            for (int i = 0; i < events.size (); i++) {
                totalScore += events.get (i).getScore ();
            }
        }

        Assert.assertTrue (totalScore == 9802);
    }
}