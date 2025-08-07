import java.util.*;

public class Q3_ZomatoDelivery {
    static int maxOrders(int[][] graph, int t, int curr, boolean[] visited) {
        visited[curr] = true;
        int max = 0;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && graph[curr][i] <= t && graph[curr][i] > 0) {
                max = Math.max(max, 1 + maxOrders(graph, t - graph[curr][i], i, visited));
            }
        }
        visited[curr] = false;
        return max;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 9, 0},
            {2, 0, 6, 4},
            {9, 6, 0, 3},
            {0, 4, 3, 0}
        };
        int t = 10;
        boolean[] visited = new boolean[4];
        int result = maxOrders(graph, t, 0, visited);
        System.out.println("Max orders: " + result);
    }
}