package questions.arrays;

class Solution {
    public int reverse(int x) {  
        int ans = 0;
        while (x != 0) { 
            int lastDigit = x % 10;
            if (ans > (Integer.MAX_VALUE / 10) || (ans == Integer.MAX_VALUE / 10 && lastDigit > 7)) {  
                return 0; 
            }  
            if (ans < (Integer.MIN_VALUE / 10) || (ans == Integer.MIN_VALUE / 10 && lastDigit < -8)) {  
                return 0;  
            }   
            ans = ans * 10 + lastDigit;  
            x /= 10;  
        }
        return ans;  
    }
}
/*
 * -2147483648 to 2147483647
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-2^31, 2^31 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed or
 * unsigned).
 * 
 * Example 1:
 * 
 * Input: x = 123
 * Output: 321
 * 
 * Example 2:
 * 
 * Input: x = -123
 * Output: -321
 * 
 * Example 3:
 * 
 * Input: x = 120
 * Output: 21
 * 
 * 
 * 
 * Constraints:
 * 
 * -2^31 <= x <= 2^31 - 1
 */