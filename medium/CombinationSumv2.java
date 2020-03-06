import java.util.*;

class CombinationSumv2 {
    public static void main(String[] args) {
        int[] inA = new int[]{1,2};
        List<List<Integer>> out = combinationSum(inA, 4);
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
            if (updatedSum > target) {
                return;
            } else if (updatedSum == target) {
                Collections.sort(updatedList);
                if (!allList.contains(updatedList)) {
                    allList.add(updatedList);
                }
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
            if (updatedSum > target) {
                return;
            } else if (updatedSum == target) {
                // also dont sort the orignial list because it will cause the wrong end element to be deleted
                // we should sort Array before calling this helper function 
                // its important to create a new list because it calls by reference, 
                boolean contains = false;
                // ok so Collections.containsAll() doenst work when [1,1,2] [2,2] it says array 1 contains 2 
                List<Integer> tempList = new ArrayList<>(currList);
                Collections.sort(tempList);
                for (List<Integer> lst: allList) {
                    if (lst.equals(tempList)) {
                        contains = true;
                        break;
                    }
                }
                if (!contains) {
                    allList.add(tempList);
                }
                return;
            } else {
                currList.add(candidate[i]);
                updatedSum += candidate[i];
                combinationSumHelpV2(candidate, currList, allList, target, updatedSum);
                currList.remove(currList.size() - 1);
            }
        }
    }
}