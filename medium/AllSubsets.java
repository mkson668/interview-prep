import java.util.*;

class AllSubsets {
    public static void main(String[] args) {
        int[] inA = new int[]{1,2,3}; 
        List<List<Integer>> retA = subsets(inA);
        System.out.println(retA);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allList = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(allList, currList, nums, 0);
        return allList;
    }

    public static void findSubsets(List<List<Integer>> allLists, List<Integer> currList, int[] nums, int start) {
        allLists.add(new ArrayList<>(currList));
        for (int i = start; i < nums.length; i++) {
            List<Integer> updatedList = new ArrayList<>(currList);
            updatedList.add(nums[i]);
            findSubsets(allLists, updatedList, nums, i + 1);
            updatedList.remove(updatedList.size() - 1);
        }
    }
}