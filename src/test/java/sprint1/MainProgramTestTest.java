package sprint1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static sprint1.MainEventType.HEPTATHLON;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class MainProgramTestTest {
    private Scanner scan = new Scanner(System.in);
    private PasswordHandler pass = new PasswordHandler();
    private String password = "DecaHepta123";
    public List<Contestant> scoreboard = new ArrayList<> ();
    private String[] decathlon = { "100 m", "Long jump", "Shot put", "High jump", "400 m", "110 m hurdles",
            "Discus throw", "Pole vault", "Javelin throw", "1500 m" };
    private String[] heptathlon = { "100 m hurdles", "High jump", "Shot put", "200 m", "Long jump",
            "Javelin throw", "800 m" };
    private ScoreCalculator calc = new ScoreCalculator();
    private MainEventType mainEvent = HEPTATHLON;
    private Excel excel = new Excel("Deca-HeptathlonScoreboard", false);


    @Test
    public void testMainEventInputH() {
        String input = "Heptathlon";
        assertEquals (input, mainEvent.eventName);
    }

    @Test
    public void testMainEventInputD() {
        mainEvent = MainEventType.DECATHLON;
        assertEquals ("Decathlon", mainEvent.eventName);
    }

    @Test
    public void testContestantRegistrationValid() {
        int contestants = 39;

        if (contestants <= 40) {
            Contestant competitor = new Contestant("Calvin Hall", 187, "USA");
            scoreboard.add (competitor);
            assertTrue (scoreboard.contains (competitor));
        } else {
            System.out.println ("Contestant registration is out of bounds for the allowed limit");
            assertFalse (contestants <= 40);
        }
    }

    @Test
    public void testContestantRegistrationInvalid() {
    int contestants = 41;

        if (contestants > 0 && contestants <= 40) {
            Contestant competitor = new Contestant("Calvin Hall", 187, "USA");
            scoreboard.add (competitor);
            assertTrue (scoreboard.contains (competitor));
        } else {
            System.out.println ("Contestant registration is out of bounds for the allowed limit");
            assertFalse (contestants <= 40);
        }
    }

        @Test
    public void testContestantInput() {
        Contestant competitor = new Contestant("Calvin Hall", 187, "USA");
        scoreboard.add (competitor);
        assertEquals (competitor.getName (), "Calvin Hall");
        assertEquals (competitor.getNumber (), 187);
        assertEquals (competitor.getCountry (), "USA");
    }

    @Test
    public void testResultInput() {
        String event = mainEvent.toString ();
        List<Double> results = new ArrayList ();
        double result = 1.5;
        results = new ArrayList<> ();
        results.add (0, 1.5);
        assertEquals (result, results.get (0), 0);
    }
}