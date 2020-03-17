import java.util.*;

class RemoveDupSortedInt {
    public static void main(String[] args) {
        int[] inA = new int[] {0,0,1,1,1,2,2,3,3,4};
        int ret = removeDuplicates(inA);
        int[] inA1 = new int[] {0,1,2,2,3,0,4,2};
        int ret1 = removeElement(inA1, 2);
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int currIntInd = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == nums[currIntInd]) {
                continue;
            } else {
                // not equal
                ++i;
                nums[i] = nums[j];
                currIntInd = j;
            }
        }
        return i + 1;
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}