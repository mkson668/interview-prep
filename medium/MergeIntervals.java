import java.util.*;

class MergeIntervals {
    public static void main(String[] args) {
        int[][] inA = new int[][]{{1,4},{0,4}};
        int[][] temp = merge(inA);
        System.out.println(Arrays.toString(temp));
    }

    public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (newInterval[1] >= interval[0]) // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}
}