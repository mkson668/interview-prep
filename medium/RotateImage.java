
class RotateImage {
    public static void main(String[] args) {
        int[][] mat = new int[4][4];
        int num = 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = num;
                num++;
            }
        }
        rotate(mat);   
    }

    // swap top row with bottom row
    public static void rotate(int[][] matrix) {
        int s = 0;
        int e = matrix.length - 1;
        while(s < e){
            // get rows and swap them
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++; e--;
        }

        // starting from top row and left column work towards bottom right corner
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}