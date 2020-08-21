package pl.grzesk075.sandbox.google;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class StringPermutationsTest {

    @Test
    public void shouldPrintPermutations1() {
        new StringPermutations().printPermutations("A");
    }

    @Test
    public void shouldPrintPermutations2() {
        new StringPermutations().printPermutations("AB");
    }

    @Test
    public void shouldPrintPermutations3() {
        new StringPermutations().printPermutations("ABC");
    }

    @Test
    public void shouldPrintPermutations4() {
        new StringPermutations().printPermutations("ABCD");
    }
}