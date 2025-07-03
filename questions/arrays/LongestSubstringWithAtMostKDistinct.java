package questions.arrays;

import java.util.HashMap;

class Solution {
    public int kDistinctChar(String s, int k) {
        int l = 0;
        int maxLen = 0;
        HashMap<Character, Integer> seen = new HashMap<>();
        char[] c = s.toCharArray();
        for (int r = 0; r < c.length; r++) {
            seen.put(c[r], seen.getOrDefault(c[r], 1) + 1);
            while (seen.size() > 2) {
                seen.put(c[l], seen.get(c[l])-1);
                if (seen.get(c[l]) == 0) {
                    seen.remove(c[l]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
/*
 * Longest Substring With At Most K Distinct Characters
 * Hard
 * 
 * Given a string s and an integer k.Find the length of the longest substring
 * with at most k distinct characters.
 * Examples:
 * 
 * Input : s = "aababbcaacc" , k = 2
 * 
 * Output : 6
 * 
 * Explanation : The longest substring with at most two distinct characters is
 * "aababb".
 * 
 * The length of the string 6.
 * 
 * Input : s = "abcddefg" , k = 3
 * 
 * Output : 4
 * 
 * Explanation : The longest substring with at most three distinct characters is
 * "bcdd".
 * 
 * The length of the string 4.
 */