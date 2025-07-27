import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSCycle {
    private static boolean dfs(int node, int parent, int[] vis, Map<Integer, List<Integer>> adj) {
        vis[node] = 1;
        for (int n : adj.getOrDefault(node, new ArrayList<>())) {
            if (vis[n] == 0) {
                if (dfs(n, node, vis, adj)) {
                    return true;
                }
            } else if (n != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        adj.put(1, Arrays.asList(2, 3));
        adj.put(2, Arrays.asList(4, 5, 6, 3));
        adj.put(3, Arrays.asList(7, 8));
        adj.put(4, List.of());
        adj.put(5, Arrays.asList(9));
        adj.put(6, Arrays.asList(10));
        adj.put(7, Arrays.asList(11));

        int[] vis = new int[12];

        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == 0) {
                if (dfs(i, -1, vis, adj)) {
                    System.out.println("CYCLE CYCLE CYCLE");
                    return;
                }
            }
        }

        System.out.println("no cycle!");
    }
}
