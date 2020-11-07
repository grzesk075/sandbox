package pl.grzesk075.sandbox.google;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShortestPathInGraphTest {

    public static final int[] G1_FROM = new int[]{};
    public static final int[] G1_TO = new int[]{};
    public static final List<Integer> PATH_0_4 = Arrays.asList();
    public static final List<Integer> PATH_4_0;

    // In static block you can initialize static final class field.
    static {
        List<Integer> path040 = new ArrayList<>(PATH_0_4);
        Collections.reverse(path040);
        PATH_4_0 = path040;
    }

    public static final List<Integer> PATH_3_8 = Arrays.asList();
    public static final List<Integer> PATH_8_3 = reverse(PATH_3_8);

    private static List<Integer> reverse(List<Integer> list) {
        List<Integer> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        return reversed;
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("@Before each test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@After each test");
    }

    @Test
    public void getShortestPathTest04() {
        assertEquals(PATH_0_4, ShortestPathInGraph.getShortestPath(0, 4, G1_FROM, G1_TO));
        assertEquals(PATH_4_0, ShortestPathInGraph.getShortestPath(4, 0, G1_FROM, G1_TO));
    }

    @Test
    public void getShortestPathTest38() {
        assertEquals(PATH_3_8, ShortestPathInGraph.getShortestPath(3, 8, G1_FROM, G1_TO));
        assertEquals(PATH_8_3, ShortestPathInGraph.getShortestPath(8, 3, G1_FROM, G1_TO));
    }
}