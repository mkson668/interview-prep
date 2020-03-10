import java.util.*;

class UniquePaths {
    public static void main(String[] args) {
        //int count = uniquePaths(23, 12);
        int count2 = uniquePathsDP(23, 12);
        System.out.println(count2);
    }

    public static int uniquePaths(int m, int n) {
        if (m < 1 || n > 100) {
            return 0;
        }
        List<List<int[]>> allPath = new ArrayList<>();
        List<int[]> onePath = new ArrayList<>();
        findAllPaths(allPath, onePath, 0, 0, m, n);
        return allPath.size();
    }

    public static void findAllPaths(List<List<int[]>> allPaths, List<int[]> path, int col, int row, int m, int n) {
        if (row >= n || col >= m) {
            return;
        } else if (row == n - 1 && col == m - 1){
            allPaths.add(new ArrayList<>(path));
            return;
        } else {
            int[][] directions = new int[][]{{1,0},{0,1}};
            for (int[] dir: directions) {
                int colUpdate = col + dir[1];
                int rowUpdate = row + dir[0];
                int[] point = new int[]{rowUpdate, colUpdate};
                path.add(point);
                findAllPaths(allPaths, path, colUpdate, rowUpdate, m, n);
                path.remove(path.size() - 1);
            }
        }
    }

    public static int uniquePathsDP(int m, int n) {
        int[][] dpArray = new int[n][m];
        for (int i = 0; i < m; i++) {
            dpArray[0][i] = 1;
        }

        for (int j = 0; j < n; j++) {
            dpArray[j][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dpArray[i][j] = dpArray[i - 1][j] + dpArray[i][j - 1];
            }
        }

        return dpArray[n - 1][m - 1];
    }
}