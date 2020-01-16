import java.util.*;

class TwoSumUniquePair {
    public static void main(String[] args) {
        int[] in = {1, 1, 2, 45, 46, 46};
        int val = 47;
        int ret = findPairs(in, val);
        System.out.println(ret);
    }
    
    public static int findPairs(int[] arr, int target) {
        int count = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        List<List<Integer>> allPairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(target - arr[i], true);
        }
        for (int j = 0; j < arr.length; j++) {
            // basically check if other number of pair exists
            if(map.get(arr[j])) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[j]);
                pair.add(target - arr[j]);
                Collections.sort(pair);
                // we must use List types to perform not elementary data type comparisons
                if (!allPairs.contains(pair)) {
                    allPairs.add(pair);
                }
            }
        }
        count = allPairs.size();
        return count;
    }
}