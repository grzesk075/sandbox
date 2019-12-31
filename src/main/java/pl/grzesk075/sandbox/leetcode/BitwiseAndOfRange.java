package pl.grzesk075.sandbox.leetcode;

public class BitwiseAndOfRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n || m == 0) {
            return m;
        }
        final int nextPowerOfTwoOrMaxInt = getNextPowerOfTwoOrMaxInt(m);
        if (n >= nextPowerOfTwoOrMaxInt && nextPowerOfTwoOrMaxInt != Integer.MAX_VALUE) {
            return 0;
        }
        int result = m;
        for (int i = m; i <= n && i >= 0; i++) {
            result &= i;
            if (result == 0) {
                break;
            }
        }
        return result;
    }

    public int rangeBitwiseAndBestOfLeetCode(int m, int n) {
        if(m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }

    static int getNextPowerOfTwoOrMaxInt(int i) {
        if (i == 0) {
            return 1;
        }
        int bit = 1 << 30;
        if (i >= bit) {
            return (1 << 31) - 1;
        }
        while (bit > 0 && (bit & i) == 0) {
            bit >>= 1;
        }
        return bit << 1;
    }
}
