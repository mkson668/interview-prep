import java.util.*;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] input = new char[][] {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'},
        };
        int total = numIslands(input);
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length == 0) {
            return count;
        }
        Boolean[][] visited = new Boolean[grid.length][grid[0].length];
        for (Boolean[] ar : visited) {
            Arrays.fill(ar, false);
        }
        Queue<int[]> q = new LinkedList<>();
        int[][] neighbors = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        // ArrayList<int[]> islandCoords = new ArrayList<int[]>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    // islandCoords.add(new int[]{i,j});
                    visited[i][j] = true;
                    q.add(new int[] { i, j });
                    // we forsure know there is min of 1 island
                    count += 1;
                    while (!q.isEmpty()) {
                        int[] currCord = q.poll();
                        for (int[] nei : neighbors) {
                            int row = currCord[0] + nei[0];
                            int col = currCord[1] + nei[1];
                            if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length
                                    && grid[row][col] == '1' && visited[row][col] == false) {
                                q.add(new int[] { row, col });
                                // set to visited
                                visited[row][col] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}