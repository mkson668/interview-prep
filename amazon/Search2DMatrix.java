class Search2DMatrix {
    public static void main(String[] args) {
        int[][] mat = { 
        { 1, 4, 7, 11, 15 }, 
        { 2, 5, 8, 12, 19 }, 
        { 3, 6, 9, 16, 22 }, 
        { 10, 13, 14, 17, 24 },
        { 18, 21, 23, 26, 30 } };
        /* int[][] mat = {
            { -1, 3 },
        };  */
        boolean found = searchMatrix2(mat, 20);
        System.out.println(found);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int column = 0;
        int row = 0;
        boolean ret = false;
        int i = 0;
        int j = 0;
        while (i < matrix.length && j < matrix[0].length) {

            System.out.println(matrix[i][j]);
            if (matrix[i][j] == target) {
                ret = true;
            }
            // the first time this is true the target value will be either on top or to the
            // left of this location
            if (matrix[i][j] > target) {
                // keep these fixed
                column = j;
                row = i;
                // check all above
                for (int k = 0; k < row; k++) {
                    if (matrix[k][column] == target) {
                        ret = true;
                        break;
                    }
                }
                if (ret == false) {
                    for (int l = 0; l < column; l++) {
                        if (matrix[row][l] == target) {
                            ret = true;
                            break;
                        }
                    }
                }

            }
            if (ret == false) {
                if (i == matrix.length - 1 && j < matrix[0].length - 1) {
                    j++;
                } else if (i < matrix.length - 1 && j == matrix[0].length - 1) {
                    i++;
                } else {
                    i++;
                    j++;
                }
            } else {
                // already found no more searching needed
                break;
            }
        }
        return ret;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        boolean found = false;
        while (i < matrix.length && j >= 0) {
            System.out.println(matrix[i][j]);
            if (target == matrix[i][j]) {
                found = true;
                break;
            }
            if (target > matrix[i][j]) {
                i++;
                continue;
            } 
            if (target < matrix[i][j]) {
                j--;
                continue;
            } 
        }
        return found;
    }
}