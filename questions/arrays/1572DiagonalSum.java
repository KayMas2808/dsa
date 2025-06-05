package questions.arrays;

class Solution {
    public int diagonalSum(int[][] mat) {
        int left = 0, right = mat[0].length - 1, sum = 0, i = 0;
        while (left < right) {
            sum += mat[i][left];
            sum += mat[i][right];
            left++;
            right--;
            i++;
        }
        if (left == right) {
            sum += mat[left][right];
            left++;
            right--;
            i++;
        }
        while (left < mat[0].length && right >= 0) {
            sum += mat[i][left];
            sum += mat[i][right];
            i++;
            left++;
            right--;
        }
        return sum;
    }
}