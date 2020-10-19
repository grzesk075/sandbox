package pl.grzesk075.sandbox.google;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertArrayEquals;

public class MergeOverlappingIntervalsTest {

    public static final LocalDateTime LOCAL_DATE_TIME_1 =
            LocalDateTime.of(2020, Month.OCTOBER, 19, 22, 35, 11);
    public static final LocalDateTime LOCAL_DATE_TIME_2 =
            LocalDateTime.of(2020, Month.OCTOBER, 19, 22, 35, 12);

    @Test
    public void mergeOverlappingIntervals() {
        LocalDateTime[][] intervals1 = new LocalDateTime[][]{
                {LOCAL_DATE_TIME_1, LOCAL_DATE_TIME_2},
                {LOCAL_DATE_TIME_1, LOCAL_DATE_TIME_2}

        };
        LocalDateTime[][] intervals1merged = new LocalDateTime[][]{
                {LOCAL_DATE_TIME_1, LOCAL_DATE_TIME_2}
        };
        assertArrayEquals(intervals1merged, MergeOverlappingIntervals.mergeOverlappingIntervals(intervals1));
    }
}