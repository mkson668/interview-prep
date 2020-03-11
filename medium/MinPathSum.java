class MinPathSum {
    public static void main(String[] args) {
        int[][] inA = new int[][]{
            {1,3,1},
            {1,5,1},
            {4,2,1}};
        int ret = minPathSum(inA);
        System.out.println(ret);
    }

    public static int minPathSum(int[][] grid) {
        if (grid[0].length == 0 || grid.length == 0 || grid == null) {
            return 0;
        }
        int[][] dpMinSF = new int[grid.length][grid[0].length];
        dpMinSF[0][0] = grid[0][0];
        // fill top row
        for (int i = 1; i < grid[0].length; i++) {
            dpMinSF[0][i] = dpMinSF[0][i - 1] + grid[0][i];
        }
        // fill left column 
        for (int j = 1; j < grid.length; j++) {
            dpMinSF[j][0] = dpMinSF[j - 1][0] + grid[j][0];
        }
        // keep taking the min so far to fill the DP array
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dpMinSF[i][j] = grid[i][j] + Math.min(dpMinSF[i - 1][j], dpMinSF[i][j - 1]);
            }
        }
        return dpMinSF[dpMinSF.length - 1][dpMinSF[0].length - 1];
    }
}