import java.util.*;

class TwoSumUniquePair {
    public static void main(String[] args) {
        int[] in = {1, 1, 2, 45, 46, 46};
        int val = 47;
        int ret = findPairs(in, val);
        System.out.println(ret);
        int ret0 = findUniquePairBruteForce(in, val);
        System.out.println(ret0);
        int counter = findOccurances(4000);
        System.out.println(counter);

    }
    
    public static int findPairs(int[] arr, int target) {
        int count = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        List<List<Integer>> allPairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(target - arr[i], true);
        }
        for (int j = 0; j < arr.length; j++) {
            // basically if the difference of 2 numbers exist in the map then 
            // it must also means that the othwe number in the pair exists
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

    public static int findUniquePairBruteForce(int[] arr, int target) {
        List<List<Integer>> validPairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    // we dont want the numbers at the same index to be a pair
                    continue;
                }
                if (arr[i] + arr[j] == target) {
                    //found valid pair
                    List<Integer> pr = new ArrayList<>();
                    pr.add(arr[i]);
                    pr.add(arr[j]);
                    Collections.sort(pr);
                    if (!validPairs.contains(pr)) {
                        validPairs.add(pr);
                    }
                }
            }
        }
        return validPairs.size();
    }

    public static int findOccurances(int n) {
        int count = 0;
        while (n > 0) {
            count += countOccurrances(n, 4);
            n--;
        }
        return count;
    }

    public static int countOccurrances(int n, int d) {
        int count = 0;
        // Loop to find the digits of N
        while (n > 0) {
            // check if the digit is D
            count = (n % 10 == d) ? count + 1 : count;
            n = n / 10;
        }
        // return the count of the
        // occurrences of D in N
        return count;
    }

}