package questions.arrays;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean checkIfPangram(String sentence) {
        List<Character> sentList = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        char[] c = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z' };
        for (int i = 0; i < 27; i++) {
            chars.add(c[i]);
        }
        char[] allArr = sentence.toLowerCase().toCharArray();
        for (int i = 0; i < allArr.length; i++) {
            sentList.add(allArr[i]);
        }
        if (sentList.containsAll(chars)) {
            return true;
        } else {
            return false;
        }
    }
}
/*
 * A pangram is a sentence where every letter of the English alphabet appears at
 * least once.
 * 
 * Given a string sentence containing only lowercase English letters, return
 * true if sentence is a pangram, or false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English
 * alphabet.
 * Example 2:
 * 
 * Input: sentence = "leetcode"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= sentence.length <= 1000
 * sentence consists of lowercase English letters.
 */