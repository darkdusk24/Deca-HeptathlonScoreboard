package sprint1;

public class PasswordHandler {

    private String password = "DecaHepta123";

    public Boolean passwordCheck(String input) {
        Boolean inputCheck = false;

        if(input.equals(password)) {
            inputCheck = true;
        }

        return inputCheck;
    }

}
