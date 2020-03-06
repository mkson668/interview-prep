import java.util.*;

class CombinationSumv2 {
    public static void main(String[] args) {
        int[] inA = new int[]{1,2,3};
        List<List<Integer>> out = combinationSum(inA, 3);
        System.out.println(out);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> currL = new ArrayList<>();
        List<List<Integer>> allList = new ArrayList<>();
        //combinationSumHelp(candidates, currL, allList, target, 0);
        combinationSumHelpV2(candidates, currL, allList, target, 0);
        return allList;
    }

    public static void combinationSumHelp(int[] candidate, List<Integer> currList, List<List<Integer>> allList,
            int target, int currsSum) {
        for (int i = 0; i < candidate.length; i++) {
            List<Integer> updatedList = new ArrayList<>(currList);
            int updatedSum = currsSum;
            if (updatedSum == target) {
                Collections.sort(updatedList);
                if (!allList.contains(updatedList)) {
                    allList.add(updatedList);
                }
                return;
            } else if (updatedSum > target) {
                return;
            } else {
                updatedList.add(candidate[i]);
                updatedSum += candidate[i];
                combinationSumHelp(candidate, updatedList, allList, target, updatedSum);
            }
        }
    }

    public static void combinationSumHelpV2(int[] candidate, List<Integer> currList, List<List<Integer>> allList,
    int target, int currsSum) {
        for (int i = 0; i < candidate.length; i++) {
            //List<Integer> updatedList = new ArrayList<>(currList);
            int updatedSum = currsSum;
            if (updatedSum == target) {
                Collections.sort(currList);
                if (!allList.contains(currList)) {
                    allList.add(currList);
                }
                return;
            } else if (updatedSum > target) {
                return;
            } else {
                currList.add(candidate[i]);
                updatedSum += candidate[i];
                combinationSumHelp(candidate, currList, allList, target, updatedSum);
                currList.remove(currList.size() - 1);
            }
        }
    }
}