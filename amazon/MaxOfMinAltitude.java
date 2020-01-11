import java.util.*;

public class MaxOfMinAltitude {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},{4, 5, 1}};
        findMaxOfMin(mat);
    }

    public static void findMaxOfMin(int[][] mat){
        List<List<Integer>> allPaths = new ArrayList<>();
        int r = 0;
        int c = 0;
        List<Integer> onePath = new ArrayList<>();
        onePath.add(mat[r][c]);
        findMaxOfMinHelper(mat, allPaths, r, c, onePath);
        int val = findMaxOfMinOfAllPaths(allPaths);
        System.out.println("max of min is: " + val);
    }

    public static int findMaxOfMinOfAllPaths(List<List<Integer>> allPaths) {
        List<Integer> mins = new ArrayList<>();
        for (List<Integer> path: allPaths) {
            path.remove(0);
            path.remove(path.size() - 1);
            Collections.sort(path);
            mins.add(path.get(0));
        }
        Collections.sort(mins,Collections.reverseOrder());
        return mins.get(0);
    }

    // generate all paths and store numbers 
    public static void findMaxOfMinHelper(int[][] mat, List<List<Integer>> paths, int r, int c, List<Integer> currPath) {
        int[][] possibleMoves = { {1 , 0}, {0 , 1} };
        // reached end add path
        if (r == mat.length - 1 && c == mat[0].length - 1){
            paths.add(currPath);
            return;
        }
        
        for (int[] dir : possibleMoves) {
            int rowShifted = dir[0] + r;
            int colShifted = dir[1] + c;
            List<Integer> updatedPath = new ArrayList<>(currPath);
            if (rowShifted < mat.length && colShifted < mat[0].length) {
                updatedPath.add(mat[rowShifted][colShifted]);
                findMaxOfMinHelper(mat, paths, rowShifted, colShifted, updatedPath);
            }
        }
    }
}