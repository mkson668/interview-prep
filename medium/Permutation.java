import java.util.*;

class Permutations {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,3};
        List<List<Integer>> ret = permute(numbers);
        System.out.println(ret);
    }

    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allPermutation = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        Set<Integer> usedIndex = new HashSet<>();
        permuteHelper(nums, allPermutation, lst, usedIndex);
        return allPermutation;
    }

    public static void permuteHelper(int[] nums, List<List<Integer>> allLists, List<Integer> currList,
            Set<Integer> usedSet) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> updatedList = new ArrayList<>(currList);
            Set<Integer> updatedUsedSet = new HashSet<>(usedSet);
            if (updatedList.size() > nums.length) {
                return;
            } else if (updatedList.size() == nums.length) {
                if (!allLists.contains(updatedList)) {
                    allLists.add(updatedList);
                }
                return;
            } else {
                if (!updatedUsedSet.contains(i)) {
                    updatedUsedSet.add(i);
                    updatedList.add(nums[i]);
                    permuteHelper(nums, allLists, updatedList, updatedUsedSet);
                } else {
                    continue;
                }
            }
        }
    }
}