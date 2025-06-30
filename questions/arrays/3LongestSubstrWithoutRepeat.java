package questions.arrays;

import java.util.HashMap;  
  
class Solution {  
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
  
        HashMap<Character, Integer> seen = new HashMap<>();
        int r = 0, l = 0;
        int maxLen = 0;
  
        while (r < s.length()) {
            char currentChar = s.charAt(r);
            if (seen.containsKey(currentChar) && seen.get(currentChar) >= l) {
                l = seen.get(currentChar) + 1;
            }
            seen.put(currentChar, r);
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
/*
 * Given a string s, find the length of the longest substring
 * without duplicate characters.
 * Example 1:
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 * 
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * 
 */