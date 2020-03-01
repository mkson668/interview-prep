import java.util.*;

class CombinationSum {
    
    public static void main(String[] args) {
        int[] can = new int[]{2,3,6,7};
        List<List<Integer>> list = combSum(can, 7);
        System.out.println(list);
    }

    public static List<List<Integer>> combSum(int[] candidates, int target) {
        List<List<Integer>> allLists = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> currList = new ArrayList<>();
        // remainder will be target, we start at 0 in array, feed a new list into it, 
        performBackTrack(allLists, candidates, currList, target, 0);
        return allLists;
    }
    public static void performBackTrack(List<List<Integer>> allLists, int[] candidates, List<Integer> currList, int remainder, int startInd) {
        if (remainder == 0) {
            
            allLists.add(new ArrayList<>(currList));
            
        } else if (remainder < 0) {
            return;
        } else {
            for (int i = startInd; i < candidates.length; i++) {
                // add integer to currlist
                currList.add(candidates[i]);
                // deduct from the reminader, dont check if its smaller our base cases will deal wiht them
                int currRemain = remainder - candidates[i];
                performBackTrack(allLists, candidates, currList, currRemain, i);
                currList.remove(currList.size() - 1);
                // Because it's backtracking. We remove the digit so that we try next possible combination.
            }
        }
    }
}