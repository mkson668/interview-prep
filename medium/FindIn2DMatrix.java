class FindIn2DMatrix {
    public static void main(String[] args) {
        int[][] mat = new int[][] {
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        boolean ret = searchMatrix(mat, 34);
        System.out.println(ret);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length - 1; j >= 0 ; j--) {
                if (target > matrix[i][matrix[0].length - 1]) {
                    break;
                } 
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}