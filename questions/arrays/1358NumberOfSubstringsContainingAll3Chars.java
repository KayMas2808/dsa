package questions.arrays;
class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0, r = 0, nStr = 0;
        boolean[] in = {false, false, false};
        char[] arr = s.toCharArray();
        while(l < s.length()-3){
            if(in[0] == in[1] == in[2] == true){
                nStr++;
            }
            in[arr[r] - 'a'] = true;
            r++;
        }
        return nStr;
    }
}
/* Given a string s consisting only of characters a, b and c.
 * 
 * Return the number of substrings containing at least one occurrence of all
 * these characters a, b and c.
 * 
 * Example 1:
 * 
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the
 * characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab",
 * "bcabc", "cab", "cabc" and "abc" (again).
 * 
 * Example 2:
 * 
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the
 * characters a, b and c are "aaacb", "aacb" and "acb".
 * 
 * Example 3:
 * 
 * Input: s = "abc"
 * Output: 1
 * 
 * Constraints:
 * 
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 */