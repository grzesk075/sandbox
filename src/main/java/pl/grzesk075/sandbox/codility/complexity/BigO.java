package pl.grzesk075.sandbox.codility.complexity;

/**
 * Time complexity depends on that, how increases number of dominant operations,
 * accordingly to increasing input data size.
 * Worst-case examples should be considered during measuring/estimation the complexity.
 * Time complexity is described in Big-O notation.
 * O(1)         constant            n % 2
 * O(log n)     logarithmic         while n > 1: n // 2; result += 1
 * O(n)         linear              for i in range(n): a *= i
 * O(n+m)       linear              for i in range(n): a *= i; for j in range(m): a *= j
 * O(n log n)
 * O(n^2)       quadratic           for i in range(n): for j in range(n): a *= j
 * O(n!)        factorial
 * O(2^n)       exponential
 *
 * Space complexity depends of number of variables to be declared (stack in case of recursion and other memory as well).
 * O(1) is for constant number of variables.
 * O(n) is if you have to declare array of length n.
 */
public class BigO {

    /** Calculate sum of that series 1 + 2 + 3 + ... + n. */
}
