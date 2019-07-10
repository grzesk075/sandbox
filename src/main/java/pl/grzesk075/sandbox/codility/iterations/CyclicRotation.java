package pl.grzesk075.sandbox.codility.iterations;

public class CyclicRotation {
    class Solution {
        public int[] solution(int[] A, int K) {
            int length = A.length;
            int[] shiftedA = new int[length];
            for(int i = 0; i< length; i++){
                shiftedA[calculateDestinationIndex(i,K,length)] = A[i];
            }
            return shiftedA;
        }

        private int calculateDestinationIndex(int index, int shift, int length) {
            return (index + shift) % length;
        }
    }
}
