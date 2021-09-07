package sprint1;

public class MainEventSelect {

    MainEventType mainEvent;
     
    public String getMainEvent() {
	return mainEvent.eventName;
    }
    
    
  public void mainEventInput(String cmd) {
	if(cmd.matches("1|h"))
	    mainEvent = MainEventType.HEPTATHLON; 
	if(cmd.matches("2|d"))  
	    mainEvent = MainEventType.DECATHLON;
    }
    
}