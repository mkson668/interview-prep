class zombiemazesolution {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
        System.out.println(minDays(grid));
    }

    private static int minDays(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int target = grid.length * grid[0].length;
        int cnt = 0, res = 0;
        // add all zombie coordinates into queue and count number of zombies
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[] { i, j });
                    cnt++;
                }
            }
        }
        // =============================================
        //
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!q.isEmpty()) {
            int size = q.size();
            // this is basic check for the maze is already filled with zombies
            // since cnt tallys up the number of zombies if this number is equal to
            // width*height that
            // means all of them are zombies already! this will be out final exit condition
            if (cnt == target)
                return res;
            // for each coordinate in the queue pop it, 
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    // check if within boundaries for up/down/left/right grids and if human
                    // if human change zombie and increase count and add the new zombie to queue
                    // THIS ONLY CHECKS FOR INBOUND COORDINATES NO NEED TO HARD CODE ALL 
                    // POSSIBLE SCENARIOS
                    // it adds it the queue for the next round of infection, the fact that this works
                    // is because the size is calculated at the beginning of each round such that the 
                    // loop i < size doesnt include the new infected zombies in the next generation
                    if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 0) {
                        cnt++;
                        q.offer(new int[] { ni, nj });
                        grid[ni][nj] = 1;
                    }
                }
            }
            // increment the time needed for total infection
            res++;
        }
        return -1;
    }
}