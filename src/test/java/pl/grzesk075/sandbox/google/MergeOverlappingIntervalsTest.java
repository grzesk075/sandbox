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
    public static final LocalDateTime LOCAL_DATE_TIME_3 =
            LocalDateTime.of(2020, Month.OCTOBER, 19, 22, 35, 13);
    public static final LocalDateTime LOCAL_DATE_TIME_4 =
            LocalDateTime.of(2020, Month.OCTOBER, 20, 22, 35, 13);
    public static final LocalDateTime LOCAL_DATE_TIME_5 =
            LocalDateTime.of(2020, Month.OCTOBER, 21, 22, 35, 13);
    public static final LocalDateTime LOCAL_DATE_TIME_6 =
            LocalDateTime.of(2020, Month.OCTOBER, 22, 22, 35, 13);



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
        assertArrayEquals(intervals1merged, MergeOverlappingIntervals.mergeOverlappingIntervals(intervals1merged));

        LocalDateTime[][] intervals2 = new LocalDateTime[][]{
                {LOCAL_DATE_TIME_1, LOCAL_DATE_TIME_2},
                {LOCAL_DATE_TIME_2, LOCAL_DATE_TIME_3}
        };
        LocalDateTime[][] intervals2merged = new LocalDateTime[][]{
                {LOCAL_DATE_TIME_1, LOCAL_DATE_TIME_3}
        };
        assertArrayEquals(intervals2merged, MergeOverlappingIntervals.mergeOverlappingIntervals(intervals2));

        LocalDateTime[][] intervals3 = new LocalDateTime[][]{
                {LOCAL_DATE_TIME_1, LOCAL_DATE_TIME_3},
                {LOCAL_DATE_TIME_2, LOCAL_DATE_TIME_3},
                {LOCAL_DATE_TIME_5, LOCAL_DATE_TIME_6}
        };
        LocalDateTime[][] intervals3merged = new LocalDateTime[][]{
                {LOCAL_DATE_TIME_1, LOCAL_DATE_TIME_3},
                {LOCAL_DATE_TIME_5, LOCAL_DATE_TIME_6}
        };
        assertArrayEquals(intervals3merged, MergeOverlappingIntervals.mergeOverlappingIntervals(intervals3));

        LocalDateTime[][] intervals4 = new LocalDateTime[][]{
                {LOCAL_DATE_TIME_1, LOCAL_DATE_TIME_4},
                {LOCAL_DATE_TIME_2, LOCAL_DATE_TIME_5},
                {LOCAL_DATE_TIME_3, LOCAL_DATE_TIME_6},
                {LOCAL_DATE_TIME_4, LOCAL_DATE_TIME_5}
        };
        LocalDateTime[][] intervals4merged = new LocalDateTime[][]{
                {LOCAL_DATE_TIME_1, LOCAL_DATE_TIME_6}
        };
        assertArrayEquals(intervals4merged, MergeOverlappingIntervals.mergeOverlappingIntervals(intervals4));
    }
}