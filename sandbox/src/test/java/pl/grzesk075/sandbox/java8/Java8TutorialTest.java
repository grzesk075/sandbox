package pl.grzesk075.sandbox.java8;

import static org.junit.Assert.*;
import static pl.grzesk075.sandbox.java8.Java8Tutorial.pow;

import org.junit.Test;

public class Java8TutorialTest {

	@Test
	public void testPow() {
		assertEquals( Long.valueOf( 4), pow( 2));
	}

	@Test
	public void testInstancePow() {
		assertEquals( Long.valueOf( 4), new Java8Tutorial().instancePow( 2));
	}

}
