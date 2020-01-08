
import java.lang.*;
import java.util.*;

public class KClosestPointToOrigin {
    public static void main(String[] args) {
        int[][] input = new int[][]{{3,3},{5,-1},{-2,4}};
        int[][] pts = kClosestVerTwo(input, 2);
        System.out.println(pts);
    }

    public static int[][] kClosest(int[][] points, int k) {
        // with respect to origin
        int[][] retPoints = new int[k][2];
        // save the distances and sort alter take the k closest points from map
        Set<Double> distances = new HashSet<>();
        Map<Double, ArrayList<int[]>> mapPointsDist = new HashMap<>();
        for (int[] currPoint: points) {
            
            Double sqrtSums = Math.pow(new Double(currPoint[0]), 2.0) + Math.pow(new Double(currPoint[1]), 2.0);
            Double dist = Math.sqrt(sqrtSums);
            if (mapPointsDist.get(dist) == null) {
                // by some chance there are mutiple points with same distance
                mapPointsDist.put(dist, new ArrayList<>());
                mapPointsDist.get(dist).add(currPoint);

            } else {
                mapPointsDist.get(dist).add(currPoint);
            }
            distances.add(dist);
        }
        List<Double> sortedDistances = new ArrayList<>(distances);
        Collections.sort(sortedDistances);
        for (int i = 0; i < k; i++) {
            int[] point = new int[2];
            Double temp =  sortedDistances.get(i);
            ArrayList<int[]> temp1 = mapPointsDist.get(temp);
            point[0] = temp1.get(0)[0];
            point[1] = temp1.get(0)[1];
            retPoints[i] = point;
        }
        return retPoints;
    }

    public static int[][] kClosestVerTwo(int[][] points, int k) {
        int size = points.length;
        Double[] distances = new Double[size];
        for (int i = 0; i < points.length; i++) {
            distances[i] = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
        }
        Arrays.sort(distances);
        Double KthLowest = distances[k - 1];
        int[][] retPoints = new int[k][2];
        int j = 0;
        for (int[] pt: points) {
            Double tempDist = Math.pow(pt[0], 2) + Math.pow(pt[1], 2);
            if (tempDist <= KthLowest) {
                retPoints[j] = pt;
                j += 1;
            }
        }
        return retPoints;
    }
}