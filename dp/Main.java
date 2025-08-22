import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution an = new Solution();
        int n = sc.nextInt();
        int[] stones = new int[n];
        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }
        System.out.println("Answer: " + an.canCross(stones));
    }

    static class Solution {
        HashMap<Integer, Integer> stoneMap;
        HashMap<Integer, Boolean>[] dp;

        public boolean rec(int cur, int prevjump, int[] stones) {
            if (cur == stones[stones.length - 1])
                return true;
            if (prevjump <= 0)
                return false;
            if (!stoneMap.containsKey(cur))
                return false;

            int index = stoneMap.get(cur);
            if (dp[index].containsKey(prevjump))
                return dp[index].get(prevjump);

            boolean res = false;
            if (stoneMap.containsKey(cur + prevjump - 1))
                res = res || rec(cur + prevjump - 1, prevjump - 1, stones);
            if (stoneMap.containsKey(cur + prevjump))
                res = res || rec(cur + prevjump, prevjump, stones);
            if (stoneMap.containsKey(cur + prevjump + 1))
                res = res || rec(cur + prevjump + 1, prevjump + 1, stones);

            dp[index].put(prevjump, res);
            return res;
        }

        public boolean canCross(int[] stones) {
            if (stones[1] != 1)
                return false;

            stoneMap = new HashMap<>();
            for (int i = 0; i < stones.length; i++)
                stoneMap.put(stones[i], i);

            dp = new HashMap[stones.length];
            for (int i = 0; i < stones.length; i++)
                dp[i] = new HashMap<>();

            return rec(1, 1, stones);
        }
    }

}
