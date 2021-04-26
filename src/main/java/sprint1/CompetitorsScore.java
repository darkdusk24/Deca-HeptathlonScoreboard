package sprint1;

import java.util.ArrayList;

public class CompetitorsScore {
    String name;
    String sportsEvent;
    double score;


public String AssignName(String name) {
    name = "Calvin";

    return name;
}
public String AssignEvent(String sportsEvent) {
    sportsEvent = "110mH";

    return sportsEvent;
}
public double AssignScore(double score) {
    score = 900;
    return score;
}

public ArrayList AssignScoreToCompetitor() {
        this.name = name;
        this.sportsEvent = sportsEvent;
        this.score = score;

        ArrayList<Object> AssignScoreToCompetitor = new ArrayList<> ();

        AssignScoreToCompetitor.add ("Calvin");
        AssignScoreToCompetitor.add ("100mH");
        AssignScoreToCompetitor.add (900);


        return AssignScoreToCompetitor;
    }

}
