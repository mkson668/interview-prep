class ClimbingStairs {
    public static void main(String[] args) {
        int ret = climbStairs(18);
        int ret2 = findStairPathsDP(18);
        System.out.println(ret2);
    }

    public static int climbStairs(int n) {
        int pathsTotal = 0;
        pathsTotal = findStairPaths(n, 0);
        return pathsTotal;
    }

    public static int findStairPaths(int n, int currStep) {
        int totalPaths = 0;
        if (currStep == n) {
            return 1;
        }
        if (currStep > n) {
            return 0;
        }
        int[] steps = new int[]{1,2};
        for (int i: steps) {
            totalPaths += findStairPaths(n, currStep + i);
        }
        return totalPaths;
    }

    public static int findStairPathsDP(int n) {
        int[] memo = new int[n + 1];
        if (n == 0) {
            return 0;
        } 
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i < memo.length; i++) {
            memo[i] = memo [i - 1] + memo[i - 2];
        }
        return memo[memo.length - 1];
    }
}