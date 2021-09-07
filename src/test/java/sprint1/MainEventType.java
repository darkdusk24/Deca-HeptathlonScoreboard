package sprint1;

enum MainEventType {
    HEPTATHLON("Heptathlon"),
    DECATHLON("Decathlon");
    public final String eventName;
    MainEventType(String event) {
        this.eventName = event;
    }
}