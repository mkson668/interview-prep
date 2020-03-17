class RemoveDupSortedInt {
    public static void main(String[] args) {
        int[] inA = new int[] {0,0,1,1,1,2,2,3,3,4};
        int ret = removeDuplicates(inA);
    }

    public static int removeDuplicates(int[] nums) {
        int currInt = 0;
        int replaceIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                replaceIndex = i + 1;
                currInt = nums[0];
                continue;
            }
            if (nums[i] != currInt) {
                currInt = nums[i];
                nums[replaceIndex] = nums[i];
                replaceIndex++;
            }
        }
        return replaceIndex;
    }
}