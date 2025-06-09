package questions.arrays;

class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;  // start from 1, so skip first (1 is already the smallest)
        
        while (k > 0) {
            long steps = countSteps(curr, n);
            if (steps <= k) {
                curr++;      // move to next sibling
                k -= steps;
            } else {
                curr *= 10;  // move to child
                k--;
            }
        }
        return curr;
    }

    private long countSteps(long curr, long n) {
        long steps = 0;
        long first = curr, last = curr;
        while (first <= n) {
            steps += Math.min(n, last) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }
        return steps;
    }
}

/*
 * Given two integers n and k, return the kth lexicographically smallest integer
 * in the range [1, n].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 13, k = 2
 * Output: 10
 * Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 * Example 2:
 * 
 * Input: n = 1, k = 1
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= n <= 109
 */