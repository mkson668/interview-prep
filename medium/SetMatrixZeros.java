import java.util.*;

class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] inA = new int[][] {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        setZeroes(inA);
        System.out.println(inA);
    }

    public static void setZeroes(int[][] matrix) {
        List<int[]> lst = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    int[] coord = new int[]{i, j};
                    lst.add(coord);
                }
            }
        }

        for (int[] point: lst) {
            int col = point[1];
            int row = point[0];
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }

            for (int j = 0; j < matrix.length; j++) {
                matrix[j][col] = 0;
            }
        }
    }
}