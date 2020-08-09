package pl.grzesk075.sandbox.google;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BrokenKeyboardTest {

    @Test
    public void getActualUserInputTest() {
        final BrokenKeyboard brokenKeyboard = new BrokenKeyboard();
        assertEquals(Arrays.asList("can serene", "canes rene"),
                brokenKeyboard.getActualUserInput("can s r n ",
                        Arrays.asList("can", "canes", "serene", "rene", "sam")));
    }

    @Test
    public void getActualUserInputTest1() {
        final BrokenKeyboard brokenKeyboard = new BrokenKeyboard();
        assertEquals(Arrays.asList(" can serene", " canes rene"),
                brokenKeyboard.getActualUserInput(" can s r n ",
                        Arrays.asList("can", "canes", "serene", "rene", "sam")));
    }
}