package pl.grzesk075.sandbox.leetcode;

public class ReverseInteger {

    class Solution {
        public int reverse(int x) {
            final String str = String.valueOf(x);
            final boolean negative = x < 0;
            final String strWithoutSign = str.substring(negative ? 1 : 0);
            final StringBuilder reverted = new StringBuilder(strWithoutSign).reverse();
            if (negative) {
                reverted.insert(0, '-');
            }
            try {
                return Integer.parseInt(reverted.toString());
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }
}
