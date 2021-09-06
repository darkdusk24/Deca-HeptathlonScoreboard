package sprint1;


import junit.framework.TestCase;
import org.junit.Test;

//import jdk.internal.icu.lang.UCharacterDirection;

//@RunWith (JUnitQuickcheck.class)
public class PasswordHandlerTest extends TestCase {
    private static final String ALPHANUMERICS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int MAX_WORD_LENGTH = 11;
    private PasswordHandler pass = new PasswordHandler ();

    /*public String generate(final SourceOfRandomness randomness, final GenerationStatus status) {
        final int stringSize = randomness.nextInt(MAX_WORD_LENGTH) + 1; // non-empty words
        final StringBuilder randomString = new StringBuilder(stringSize);
        IntStream.range(0, stringSize)
                .forEach(
                        ignored -> {
                            final int randomIndex = randomness.nextInt(ALPHANUMERICS.length());
                            randomString.append(ALPHANUMERICS.charAt(randomIndex));
                        });
        System.out.println (randomString.toString());
        return randomString.toString();

    }*/
    @Test
    public void testPasswordCheckValid() {
        assertTrue (pass.passwordCheck ("DecaHepta123"));
    }

    @Test
    public void testPasswordCheckInValid() {
        assertFalse (pass.passwordCheck ("KissMyGrits"));
    }

    @Test
    public void testPasswordCheckBlank() {
        assertFalse (pass.passwordCheck (" "));
    }
}