package pl.grzesk075.sandbox.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Dynamic programming. Time and space complexity O(n*n).
 */
public class PascalTriangle {

    class Solution {

        public static final int SIDE_VALUE = 1;

        public List<List<Integer>> generate(int numRows) {

            List<List<Integer>> pascalTriangle = new ArrayList<>();
            if (numRows == 0) {
                return pascalTriangle;
            }
            List<Integer> row = Arrays.asList(SIDE_VALUE);
            pascalTriangle.add(row);
            for (int numRow = 2; numRow <= numRows; numRow++) {
                List<Integer> previousRow = row;
                row = new ArrayList<>(numRow);
                row.add(SIDE_VALUE);
                for (int i = 1; i < numRow - 1; i++) {
                    row.add(previousRow.get(i - 1) + previousRow.get(i));
                }
                row.add(SIDE_VALUE);
                pascalTriangle.add(row);
            }
            return pascalTriangle;
        }
    }
}
