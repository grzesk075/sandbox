package pl.grzesk075.sandbox.codility.complexity;

/**
 * Time and memory complexityO(1).
 */
public class FrogJmp {
    class Solution {
        public int solution(int X, int Y, int D) {
            final int distance = Y - X;
            final int jumpsFloor = distance / D;
            final int jumpsRest = distance % D;
            final int jumps = jumpsRest == 0 ? jumpsFloor : jumpsFloor + 1;
            return jumps;
        }
    }
}
