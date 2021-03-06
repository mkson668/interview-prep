import java.util.*;

class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> outA = combine(4, 2);
        System.out.println(outA);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> allLists = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        findAllCombinationsV2(allLists, currList, k, n);
        return allLists;
    }

    public static void findAllCombinationsV2(List<List<Integer>> allList, List<Integer> currList, int sizeLimit, int numbers) {
        if (currList.size() >= sizeLimit) {
            List<Integer> tempList = new ArrayList<>(currList);
            allList.add(new ArrayList<>(tempList));
            return;
        } else {
            while (numbers > 0) {
                currList.add(numbers);
                numbers--;
                findAllCombinationsV2(allList, currList, sizeLimit, numbers);
                currList.remove(currList.size() - 1);
            }
        }
    }

}