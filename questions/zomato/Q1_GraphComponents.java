import java.util.*;

public class Q1_GraphComponents {
    static void dfs(int node, int componentId, List<List<Integer>> adj, int[] component) {
        component[node] = componentId;
        for (int neighbor : adj.get(node)) {
            if (component[neighbor] == -1)
                dfs(neighbor, componentId, adj, component);
        }
    }

    public static void main(String[] args) {
        int n = 6; // number of nodes
        int[][] edges = { { 0, 1 }, { 2, 3 }, { 4, 5 } };
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] component = new int[n];
        Arrays.fill(component, -1);
        int componentId = 0;
        for (int i = 0; i < n; i++) {
            if (component[i] == -1) {
                dfs(i, componentId++, adj, component);
            }
        }

        System.out.println("Number of components: " + componentId);
        System.out.println("Component map: " + Arrays.toString(component));

        int[][] queries = { { 0, 1 }, { 0, 2 } };
        for (int[] query : queries) {
            System.out.println("Same component? " + (component[query[0]] == component[query[1]]));
        }
    }
}