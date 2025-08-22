import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BFSDFS {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        adj.put(1, Arrays.asList(2, 3));
        adj.put(2, Arrays.asList(4, 5, 6, 3));
        adj.put(3, Arrays.asList(7, 8));
        adj.put(4, Arrays.asList());
        adj.put(5, Arrays.asList(9));
        adj.put(6, Arrays.asList(10));
        adj.put(7, Arrays.asList(11));

        int root = 1;
        List<Integer> ans = bfs(adj, root);
        for (int i : ans) {
            System.out.print(i + " -> ");
        }
    }

    public static List<Integer> bfs(Map<Integer, List<Integer>> adj, int root) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> bf = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        q.add(root);
        visited.add(root);

        while (!q.isEmpty()) {
            int curr = q.poll();
            bf.add(curr);

            for (int neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    q.add(neighbor);
                    visited.add(neighbor);
                } else { // detect cycle
                    System.out.println("cycle? cycle." + neighbor);
                }
            }
        }
        return bf;
    }

    public static List<Integer> dfs(Map<Integer, List<Integer>> adj, int root) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> df = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        s.push(root);
        visited.add(root);

        while (!s.isEmpty()) {
            int curr = s.pop();
            df.add(curr);

            for (int neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    s.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return df;
    }
}