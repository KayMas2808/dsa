import java.util.*;

public class Q6_GridDistanceToGuard {
    static int[][] findDistances(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, -1);
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 'G') {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] d : dirs) {
                int ni = curr[0] + d[0], nj = curr[1] + d[1];
                if (ni >= 0 && nj >= 0 && ni < m && nj < n &&
                    grid[ni][nj] != 'W' && dist[ni][nj] == -1) {
                    dist[ni][nj] = dist[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'0', '0', 'G'},
            {'0', 'W', '0'},
            {'0', '0', '0'}
        };
        int[][] distances = findDistances(grid);
        for (int[] row : distances)
            System.out.println(Arrays.toString(row));
    }
}