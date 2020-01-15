class SpiralMatrix2 {
    public static void main(String[] args) {
        int[][] ret = generateMatrix(3);
        System.out.println(ret);
    }

    public static int[][] generateMatrix(int n) {
        
        int currVal = 1; // lets just assume n is positive man not stupid stuff
        
        int[][] matrix = new int[n][n];
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        if (n <= 0) {
            return matrix;
        }
        while (left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = currVal++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = currVal++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = currVal++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = currVal++;
            }
            left++;
        }
        return matrix;
    }


}