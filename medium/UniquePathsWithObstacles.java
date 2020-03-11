class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] inA = new int[][]{
            {1,0}
        };
        int ret = uniquePathsWObstacles(inA);
        System.out.println(ret);
    }

    public static int uniquePathsWObstacles(int[][] obstacleGrid) {
        boolean blocked = false;
        int[][] dpMap = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (!blocked) {
                if (obstacleGrid[0][i] == 1) {
                    dpMap[0][i] = 0;
                    blocked = true;
                } else {
                    dpMap[0][i] = 1;
                }
            } else {
                dpMap[0][i] = 0;
            }
        }
        blocked = false;
        for (int j = 0; j < obstacleGrid.length; j++) {
            if (!blocked) {
                if (obstacleGrid[j][0] == 1) {
                    dpMap[j][0] = 0;
                    blocked = true;
                } else {
                    dpMap[j][0] = 1;
                }
            } else {
                dpMap[j][0] = 0;
            }
        }

        for (int i = 1; i < dpMap.length; i++) {
            for (int j = 1; j < dpMap[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dpMap[i][j] = dpMap[i - 1][j] + dpMap[i][j - 1];
                } else {
                    dpMap[i][j] = 0;
                }
            }
        }
        return dpMap[dpMap.length - 1][dpMap[0].length - 1];
    }
}