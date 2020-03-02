import java.util.*;
class NextPermutation {
    public static void main(String[] args) {
        int[] ar = new int[]{1,2,3};
        nextPermutation(ar);
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;
        boolean swaped = false;
        int swapInd;
        for (int i = nums.length - 1, j = nums.length - 2; i >= 1 && j >= 0; i--, j--) {
            if (nums[j] < nums[i]) {
                int currHigh = nums[j + 1];
                // set default
                swapInd = j + 1;
                int low = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    // high                      low
                    if (nums[k] <= currHigh && nums[k] > low) {
                        swapInd = k;
                    }
                }
                int temp = nums[swapInd];
                nums[swapInd] = nums[j];
                nums[j] = temp;
                Arrays.sort(nums, j + 1, nums.length);
                swaped = true;
                break;
            }
        } 
        if (!swaped) {
            // by default increasing
            Arrays.sort(nums);
        }
    }
}