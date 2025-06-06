package questions.arrays;

class Solution {
    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px == py) return;
        // Always keep the lexicographically smaller char as the root
        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26]; // only lowercase letters

        for (int i = 0; i < 26; i++) parent[i] = i;
        // parent[0] = 0, parent[1] = 1, parent[2] = 2....

        //abc, cde
        for (int i = 0; i < s1.length(); i++) {
            union(parent, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            char smallest = (char)(find(parent, ch - 'a') + 'a');
            sb.append(smallest);
        }
        return sb.toString();
    }
}


/*
 * You are given two strings of the same length s1 and s2 and a string baseStr.
 * 
 * We say s1[i] and s2[i] are equivalent characters.
 * 
 * For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' ==
 * 'd', and 'c' == 'e'.
 * Equivalent characters follow the usual rules of any equivalence relation:
 * 
 * Reflexivity: 'a' == 'a'.
 * Symmetry: 'a' == 'b' implies 'b' == 'a'.
 * Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
 * For example, given the equivalency information from s1 = "abc" and s2 =
 * "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab"
 * is the lexicographically smallest equivalent string of baseStr.
 * 
 * Return the lexicographically smallest equivalent string of baseStr by using
 * the equivalency information from s1 and s2.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "parker", s2 = "morris", baseStr = "parser"
 * Output: "makkek"
 * Explanation: Based on the equivalency information in s1 and s2, we can group
 * their characters as [m,p], [a,o], [k,r,s], [e,i].
 * The characters in each group are equivalent and sorted in lexicographical
 * order.
 * So the answer is "makkek".
 * Example 2:
 * 
 * Input: s1 = "hello", s2 = "world", baseStr = "hold"
 * Output: "hdld"
 * Explanation: Based on the equivalency information in s1 and s2, we can group
 * their characters as [h,w], [d,e,o], [l,r].
 * So only the second letter 'o' in baseStr is changed to 'd', the answer is
 * "hdld".
 * Example 3:
 * 
 * Input: s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
 * Output: "aauaaaaada"
 * Explanation: We group the equivalent characters in s1 and s2 as
 * [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in baseStr except 'u'
 * and 'd' are transformed to 'a', the answer is "aauaaaaada".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s1.length, s2.length, baseStr <= 1000
 * s1.length == s2.length
 * s1, s2, and baseStr consist of lowercase English letters.
 */