import java.util.ArrayList;
import java.util.List;

class JumpGame {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        //boolean val = canJump(nums);
        boolean val2 = canJumpReverse(nums);
        System.out.println(val2);
    }

    public static boolean canJump(int[] nums) {
        List<Boolean> lstBool = new ArrayList<>();
        checkIfReached(nums, lstBool, 0);
        if (lstBool.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static void checkIfReached(int[] nums, List<Boolean> reached, int currIndex) {
        if (currIndex >= nums.length - 1) {
            reached.add(true);
            return;
        } else {
            int jumpNum = nums[currIndex];
            while (jumpNum > 0) {
                int newCurrIndex = currIndex + jumpNum;
                jumpNum--;
                checkIfReached(nums, reached, newCurrIndex);
                if (!reached.isEmpty()) {
                    return;
                }
            }
        }
    }

    // go backwards check if this index can be reached by indices before it
    public static boolean canJumpReverse(int[] nums) {
        int lastGoodIndexPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIndexPosition) {
                lastGoodIndexPosition = i;
            }
        }
        return lastGoodIndexPosition == 0;
    }
}