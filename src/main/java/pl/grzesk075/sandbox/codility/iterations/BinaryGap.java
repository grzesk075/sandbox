package pl.grzesk075.sandbox.codility.iterations;

public class BinaryGap {

    public static void main(String[] args) {

        Solution solution = new BinaryGap().new Solution();
        System.out.println(solution.solution(1));
        System.out.println(solution.solution(2));
        System.out.println(solution.solution(3));
        System.out.println(solution.solution(4));
        System.out.println(solution.solution(5));
        System.out.println(solution.solution(6));
        System.out.println(solution.solution(7));
        System.out.println(solution.solution(8));
        System.out.println(solution.solution(9));
        System.out.println(solution.solution(1041));
        System.out.println(solution.solution(Integer.MAX_VALUE));
    }

    class Solution {
    
        public int solution(int N) {
        
            String binaryString = Integer.toBinaryString(N);

            int maxGap = 0;
            int gap = 0;
            for (int i = 0; i < binaryString.length(); i++) {
                
                if (binaryString.charAt(i) == '0') {
                    gap++;
                } else {
                    if (gap > maxGap) {
                        maxGap = gap;
                    }
                    gap = 0;
                }
            }
            return maxGap;
        }
    }
}
