package sprint1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static sprint1.MainEventType.DECATHLON;
import static sprint1.MainEventType.HEPTATHLON;

public class MainEventSelectTest {
    MainEventType mainEvent;
    MainEventSelect underTest = new MainEventSelect ();
    /*@Test
    public void getMainEvent() {

        String event = "heptathlon";
        //underTest.mainEvent.eventName = "heptathlon";
        //mainEvent = new MainEventType();
        String expected = mainEvent.eventName;
        //System.out.println (expected);
        //assertEquals (expected, underTest.getMainEvent ());
    }*/

    @Test
    public void mainEventInputHeptaH() {
        String cmd = "h";
        if(cmd.matches("1|h"))
            mainEvent = HEPTATHLON;
        if(cmd.matches("2|d"))
            mainEvent = DECATHLON;
        assertEquals(mainEvent, HEPTATHLON);
    }

    @Test
    public void mainEventInputHepta1() {
        String cmd = "1";
        if(cmd.matches("1|h"))
            mainEvent = HEPTATHLON;
        if(cmd.matches("2|d"))
            mainEvent = DECATHLON;
        assertEquals(mainEvent, HEPTATHLON);
    }

    @Test
    public void mainEventInputHepta1Invalid() {
        String cmd = "0";
        if(cmd.matches("1|h"))
            mainEvent = HEPTATHLON;
        if(cmd.matches("2|d"))
            mainEvent = DECATHLON;
        assertNotSame (mainEvent, HEPTATHLON);
    }

    @Test
    public void mainEventInputDecaD() {
        String cmd = "d";
        if(cmd.matches("1|h"))
            mainEvent = HEPTATHLON;
        if(cmd.matches("2|d"))
            mainEvent = DECATHLON;
        assertEquals(mainEvent, DECATHLON);
    }

    @Test
    public void mainEventInputDeca2() {
        String cmd = "2";
        if(cmd.matches("1|h"))
            mainEvent = HEPTATHLON;
        if(cmd.matches("2|d"))
            mainEvent = DECATHLON;
        assertEquals(mainEvent, DECATHLON);
    }

    @Test
    public void mainEventInputDeca2Invalid() {
        String cmd = "3";
        if(cmd.matches("1|h"))
            mainEvent = HEPTATHLON;
        if(cmd.matches("2|d"))
            mainEvent = DECATHLON;
        assertNotSame (mainEvent, DECATHLON);
    }

    }
