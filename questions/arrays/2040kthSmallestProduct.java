package questions.arrays;

class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        // Define the search space for the product's value.
        // The values are slightly larger than the theoretical min/max to be safe.
        long low = -100001L * 100001L;
        long high = 100001L * 100001L;
        long ans = high;

        // Binary search for the k-th smallest product value.
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            // Count how many products are less than or equal to `mid`.
            if (countLessOrEqual(nums1, nums2, mid) >= k) {
                // If the count is >= k, `mid` is a potential answer.
                // We try to find an even smaller value, so we search in the lower half.
                ans = mid;
                high = mid - 1;
            } else {
                // If the count is < k, `mid` is too small. We need to look for a larger product.
                low = mid + 1;
            }
        }
        return ans;
    }

    /**
     * Counts the number of products `n1 * n2` that are less than or equal to `productThreshold`.
     * This is the core helper for the binary search. It has a time complexity of O(N * log M).
     *
     * @param nums1 An array of integers.
     * @param nums2 An array of integers.
     * @param productThreshold The value to check against.
     * @return The total count of products <= productThreshold.
     */
    private long countLessOrEqual(int[] nums1, int[] nums2, long productThreshold) {
        long count = 0;
        
        for (int n1 : nums1) {
            if (n1 == 0) {
                // If n1 is 0, the product is 0.
                // If the threshold is non-negative, all n2's will result in a valid product (0 <= threshold).
                if (productThreshold >= 0) {
                    count += nums2.length;
                }
            } else if (n1 > 0) {
                // If n1 > 0, we need n2 <= productThreshold / n1.
                // We count how many elements in the sorted nums2 satisfy this.
                int l = 0, r = nums2.length - 1;
                int boundary = -1; // Index of the rightmost valid element in nums2
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if ((long) n1 * nums2[m] <= productThreshold) {
                        boundary = m; // This n2 is valid, so all to its left are also valid.
                        l = m + 1;    // Try to find a larger valid n2 to the right.
                    } else {
                        r = m - 1;
                    }
                }
                count += (boundary + 1);
            } else { // n1 < 0
                // If n1 < 0, the inequality flips when we divide: n2 >= productThreshold / n1.
                // We count how many elements in the sorted nums2 satisfy this.
                int l = 0, r = nums2.length - 1;
                int boundary = nums2.length; // Index of the leftmost valid element in nums2
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if ((long) n1 * nums2[m] <= productThreshold) {
                        boundary = m; // This n2 is valid.
                        r = m - 1;    // Try to find an even more valid n2 (larger value) to the left.
                    } else {
                        l = m + 1;
                    }
                }
                count += (nums2.length - boundary);
            }
        }
        return count;
    }
}
/*
 * Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an
 * integer k, return the kth (1-based) smallest product of nums1[i] * nums2[j]
 * where 0 <= i < nums1.length and 0 <= j < nums2.length.
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [2,5], nums2 = [3,4], k = 2
 * Output: 8
 * Explanation: The 2 smallest products are:
 * - nums1[0] * nums2[0] = 2 * 3 = 6
 * - nums1[0] * nums2[1] = 2 * 4 = 8
 * The 2nd smallest product is 8.
 * Example 2:
 * 
 * Input: nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
 * Output: 0
 * Explanation: The 6 smallest products are:
 * - nums1[0] * nums2[1] = (-4) * 4 = -16
 * - nums1[0] * nums2[0] = (-4) * 2 = -8
 * - nums1[1] * nums2[1] = (-2) * 4 = -8
 * - nums1[1] * nums2[0] = (-2) * 2 = -4
 * - nums1[2] * nums2[0] = 0 * 2 = 0
 * - nums1[2] * nums2[1] = 0 * 4 = 0
 * The 6th smallest product is 0.
 * Example 3:
 * 
 * Input: nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
 * Output: -6
 * Explanation: The 3 smallest products are:
 * - nums1[0] * nums2[4] = (-2) * 5 = -10
 * - nums1[0] * nums2[3] = (-2) * 4 = -8
 * - nums1[4] * nums2[0] = 2 * (-3) = -6
 * The 3rd smallest product is -6.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums1.length, nums2.length <= 5 * 104
 * -105 <= nums1[i], nums2[j] <= 105
 * 1 <= k <= nums1.length * nums2.length
 * nums1 and nums2 are sorted.
 */