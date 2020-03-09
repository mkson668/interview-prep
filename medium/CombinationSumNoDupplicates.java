import java.util.*;

class CombinationSumNoDuplicates {
    public static void main(String[] args) {
        List<List<Integer>> outA = new ArrayList<>();
        int[] inA = new int[] {10,1,2,7,6,1,5};
        outA = combinationSum2(inA, 8);
        System.out.println(outA);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> allLists = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        List<Integer> usedCandidates = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, 0, lst, allLists, usedCandidates);
        return allLists;
    }

    public static void combinationSum2Helper(int[] candidates, int target, int currSum, List<Integer> currList,
            List<List<Integer>> allList, List<Integer> usedIndexList) {
        for (int i = 0; i < candidates.length; i++) {
            int updatedSum = currSum;
            List<Integer> updatedIndexList = new ArrayList<>(usedIndexList);
            List<Integer> updatedList = new ArrayList<>(currList);
            if (currSum > target) {
                return;
            } else if (updatedSum == target) {
                Collections.sort(updatedList);
                if (!allList.contains(updatedList)) {
                    allList.add(new ArrayList<>(updatedList));
                }
                // we return because we sorted teh array first, and we are now at target, adding
                // anymore numbers
                // would only make it exceed the targer number
                return;
            } else {
                if (!usedIndexList.contains(i)) {
                    updatedIndexList.add(i);
                    updatedSum += candidates[i];
                    updatedList.add(candidates[i]);
                    combinationSum2Helper(candidates, target, updatedSum, updatedList, allList, updatedIndexList);
                } 
            }
        }
    }
}