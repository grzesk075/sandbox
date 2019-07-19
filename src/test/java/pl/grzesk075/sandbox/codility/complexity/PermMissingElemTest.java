package pl.grzesk075.sandbox.codility.complexity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PermMissingElemTest {
    @Test
    public void shouldFindMissingElement() {
        final PermMissingElem.Solution solution = new PermMissingElem().new Solution();

        assertEquals(1, solution.solution(new int[]{2}));
        assertEquals(2, solution.solution(new int[]{1}));
        assertEquals(2, solution.solution(new int[]{1, 3}));
        assertEquals(3, solution.solution(new int[]{1, 2}));
        assertEquals(1, solution.solution(new int[]{3, 2}));
        assertEquals(1, solution.solution(new int[]{2, 3}));
        assertEquals(4, solution.solution(new int[]{3, 2, 5, 1}));

        final int missing = 78652;
        final int N = 100000;
        final int[] A = new int[N];
        int shift = -1;
        for (int v = 1; v <= N + 1; v++) {
            if (v == missing) {
                shift = -2;
                continue;
            }
            A[v + shift] = v;
        }
        assertEquals(missing, solution.solution(A));

        swap(A,23,457);
        swap(A,274,742);
        swap(A,1156,678);
        swap(A,34,667);
        assertEquals(missing, solution.solution(A));
    }

    private void swap(final int[] A, final int i1, final int i2) {
        final int temp = A[i1];
        A[i1] = A[i2];
        A[i2] = temp;
    }
}