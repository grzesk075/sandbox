package pl.grzesk075.sandbox.google;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Merge overlapping intervals.
 * <p>
 * Problem statement:
 * You are given an array (list) of interval pairs as input where each interval has a start and end timestamp.
 * The input array is sorted by starting timestamps.
 * You are required to merge overlapping intervals and return output array (list).
 */
public class MergeOverlappingIntervals {
    public static LocalDateTime[][] mergeOverlappingIntervals(LocalDateTime[][] intervals) {
        List<LocalDateTime[]> merged = new ArrayList<>();

        LocalDateTime begin = null, end = null;
        for (LocalDateTime[] interval : intervals) {
            if (begin == null) {
                begin = interval[0];
                end = interval[1];
                continue;
            }

        }
        if (begin != null) {
            merged.add(new LocalDateTime[]{begin, end});
        }

        LocalDateTime[][] mergedIntervals = new LocalDateTime[merged.size()][2];
        int i = 0;
        for (LocalDateTime[] localDateTimes : merged) {
            mergedIntervals[i++] = localDateTimes;
        }
        return mergedIntervals;
    }
}
