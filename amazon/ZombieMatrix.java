
import java.util.LinkedList;
import java.util.Queue;


public class ZombieMatrix {
    public static void main(String[] args) {
        int[][] inputMat = {
            {1,0,0},
            {0,0,0},
            {0,0,0},
        };
        // int ret = findTotalInfectionTime(inputMat);
        int ret2 = findTimeForInfection(inputMat);
        System.out.println("it will take " + ret2 + " iterations");
    }

    public static int findTotalInfectionTime(int[][] mat) {
        int matColumns = mat[0].length;
        int matRows = mat.length;
        int[][] currMat = mat;
        int[][] nextMat = new int[matRows][matColumns];

        int time = 1;
        // bc: all are zombies already
        if (checkIfAllInfected(mat)) {
            return 0;
        }
        for (int k = 0; k < (matColumns * matRows / 2); k++) {
            for (int i = 0; i < matRows; i++) {
                for (int j = 0; j < matColumns; j++) {
                    if (currMat[i][j] == 1) {
                        if (i == 0 && j == 0) {
                            nextMat[0][0] = 1;
                            nextMat[1][0] = 1;
                            nextMat[0][1] = 1;
                        } else if (i == 0 && j == matColumns - 1) {
                            nextMat[0][matColumns - 1] = 1;
                            nextMat[1][matColumns - 1] = 1;
                            nextMat[0][matColumns - 2] = 1;
                        } else if (i == matRows - 1 && j == 0) {
                            nextMat[matRows - 1][0] = 1;
                            nextMat[matRows - 2][0] = 1;
                            nextMat[matRows - 1][1] = 1;
                        } else if (i == matRows - 1 && j == matColumns - 1) {
                            nextMat[matRows - 1][matColumns - 1] = 1;
                            nextMat[matRows - 1][matColumns - 2] = 1;
                            nextMat[matRows - 2][matColumns - 1] = 1;
                        } else if (i == 0 && j > 0 && j < matColumns - 1) {
                            nextMat[i][j] = 1;
                            nextMat[i][j - 1] = 1;
                            nextMat[i][j + 1] = 1;
                            nextMat[1][j] = 1;
                        } else if (i == matRows - 1 && j > 0 && j < matColumns - 1) {
                            nextMat[i][j] = 1;
                            nextMat[i][j - 1] = 1;
                            nextMat[i][j + 1] = 1;
                            nextMat[i - 1][j] = 1;
                        } else if (i > 0 && i < matRows - 1 && j == 0) {
                            nextMat[i][j] = 1;
                            nextMat[i + 1][j] = 1;
                            nextMat[i - 1][j] = 1;
                            nextMat[i][j + 1] = 1;
                        } else if (i > 0 && i < matRows - 1 && j == matColumns - 1) {
                            nextMat[i][j] = 1;
                            nextMat[i + 1][j] = 1;
                            nextMat[i - 1][j] = 1;
                            nextMat[i][j - 1] = 1;
                        } else {
                            nextMat[i][j] = 1;
                            nextMat[i - 1][j] = 1;
                            nextMat[i + 1][j] = 1;
                            nextMat[i][j - 1] = 1;
                            nextMat[i][j + 1] = 1;
                        }
                    }
                }
                // should copy nextMat to Currmat then do again
            }
            currMat = nextMat;
            nextMat = new int[matRows][matColumns];
            if (!checkIfAllInfected(currMat)) {
                time += 1;
            }
        }
        return time;
    }

    /* helper to detect it humans still exist */
    public static Boolean checkIfAllInfected(int[][] mat) {
        boolean allInfect = true;
        found:
        // columns then rows
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    allInfect = false;
                    System.out.println("someone is still human!");
                    break found;
                }
            }
        }
        return allInfect;
    }

    public static int findTimeForInfection(int[][] mat) {
        int cols = mat[0].length;
        int rows = mat.length;
        int hours = 0, numZombies = 0;
        Queue<int[]> zombCoordQueue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    numZombies += 1;
                    zombCoordQueue.add(new int[]{i,j});
                }
            }
        }
        // if right off the bat all are zombies then just return 0 hours no need to for extra work;
        if (numZombies == cols*rows) {
            return 0;
        }
        int[][] neighbourOffset = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        while(!zombCoordQueue.isEmpty()) {
            // if (numZombies == cols*rows) {
            //     return hours;
            // }
            int currIterationSize = zombCoordQueue.size();
            for (int i = 0; i < currIterationSize; i++) {
                int[] currCoord = zombCoordQueue.remove();
                for (int j = 0; j < neighbourOffset.length; j++) {
                    int[] offset = neighbourOffset[j];
                    int xCoord = offset[0] + currCoord[0];
                    int yCoord = offset[1] + currCoord[1];
                    if (xCoord >= 0 && xCoord < rows && yCoord >= 0 && yCoord < cols && mat[xCoord][yCoord] == 0) {
                        numZombies += 1;
                        zombCoordQueue.add(new int[]{xCoord, yCoord});
                        mat[xCoord][yCoord] = 1;
                    }
                }
            }
            hours += 1;  
        }
        return hours - 1;
    }
}