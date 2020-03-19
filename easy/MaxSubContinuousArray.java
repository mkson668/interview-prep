import java.util.*;

class MaxSubContinuousArray {
    public static void main(String[] args) {
        int[] inA = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int ret = maxSubArrayVer2(inA);
    }

    // O(n^2)
    public static int maxSubArray(int[] nums) {
        int currHigh = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tempSum = 0;
            for (int j = i; j < nums.length; j++) {
                tempSum += nums[j];
                if (tempSum > currHigh) {
                    currHigh = tempSum;
                }
            }
        }
        return currHigh;
    }

    // O(n)
    public static int maxSubArrayVer2(int[] A) {
        int max = Integer.MIN_VALUE;
        int[] dpA = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                dpA[i] = A[i];
                max = dpA[i];
                continue;
            }
            dpA[i] = Math.max(dpA[i - 1] + A[i], A[i]);
            if (dpA[i] > max) max = dpA[i];
        }
        return max;
    }
}

