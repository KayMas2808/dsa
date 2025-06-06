package questions.arrays;

class Solution {
    public String robotWithString(String s) {
        String t = "";
        String p = "";
        char[] sArr = s.toCharArray();
        for(int i = 0; i < sArr.length - 1; i++){
            if (sArr[i] > sArr[i + 1]){
                String[] th = op1(s, t);
                s = th[0];
                t = th[1];
            }
            else if(sArr){}
        }
        return p;
    }
    public String[] op1(String s, String t){
        System.out.println("Performing operation 1: ");
        String[] res = new String[2];
        char c = s.toCharArray()[0];
        t = t + "" + c;
        s = s.substring(1, s.length());
        res[0] = s;
        res[1] = t;
        return res;
    }
    public String[] op2(String t, String p){
        System.out.println("Performing operation 2: ");
        String[] res = new String[2];
        char c = t.toCharArray()[t.length() - 1];
        p = p + "" + c;
        t = t.substring(0, t.length() - 1);
        res[0] = t;
        res[1] = p;
        return res;
    }
}
/*
 * You are given a string s and a robot that currently holds an empty string t.
 * Apply one of the following operations until s and t are both empty:
 * 
 * Remove the first character of a string s and give it to the robot. The robot
 * will append this character to the string t.
 * Remove the last character of a string t and give it to the robot. The robot
 * will write this character on paper.
 * Return the lexicographically smallest string that can be written on the
 * paper.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "zza"
 * Output: "azz"
 * Explanation: Let p denote the written string.
 * Initially p="", s="zza", t="".
 * Perform first operation three times p="", s="", t="zza".
 * Perform second operation three times p="azz", s="", t="".
 * Example 2:
 * 
 * Input: s = "bac"
 * Output: "abc"
 * Explanation: Let p denote the written string.
 * Perform first operation twice p="", s="c", t="ba".
 * Perform second operation twice p="ab", s="c", t="".
 * Perform first operation p="ab", s="", t="c".
 * Perform second operation p="abc", s="", t="".
 * Example 3:
 * 
 * Input: s = "bdda"
 * Output: "addb"
 * Explanation: Let p denote the written string.
 * Initially p="", s="bdda", t="".
 * Perform first operation four times p="", s="", t="bdda".
 * Perform second operation four times p="addb", s="", t="".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105
 * s consists of only English lowercase letters.
 */
