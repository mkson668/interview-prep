import java.util.*;
class MostFrequentInteger {
    public static void main(String[] args) {
        int[] inA = new int[]{1,2,3,4,4,5,6,7,7,8,9,9,9,9,9,9};
        int ret = findMostFrequent(inA);
        System.out.println(ret);
    }

    public static int findMostFrequent(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return Integer.MIN_VALUE;
        }
        int currHighInt = 0;
        int currHigh = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (mp.get(arr[i]) == null) {
                if (currHigh == 0) {
                    currHighInt = arr[i];
                    currHigh = 1;
                }
                mp.put(arr[i], 1);
            } else {
                int temp = mp.get(arr[i]);
                temp += 1;
                if (temp > currHigh) {
                    currHigh = temp;
                    currHighInt = arr[i];
                }
                mp.put(arr[i], temp);
            }
        }
        return currHighInt;
    }
}