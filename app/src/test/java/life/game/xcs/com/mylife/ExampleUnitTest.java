package life.game.xcs.com.mylife;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test(){

                String a = "hello2";
                final String b = "hello";
                String d = "hello";
                String c = b + 2;
                String e = d + 2;
                System.out.println("a == c:" +(a == c));
                System.out.println("a == e:" +(a == e));

    }
}