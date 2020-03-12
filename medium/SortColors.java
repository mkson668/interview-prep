class SortColors {
    public static void main(String[] args) {
        int[] inA = new int[]{2,0,2,1,1,0};
        sortColors(inA);
    }

    public static void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else if (nums[i] == 1) {
                ones++;
            } else {
                twos++;
            }
        }

        int j = 0;
        while (zeros > 0 && j < nums.length) {
            nums[j] = 0;
            j++;
            zeros--;
        }

        while (ones > 0 && j < nums.length) {
            nums[j] = 1;
            j++;
            ones--;
        }

        while (twos > 0 && j < nums.length) {
            nums[j] = 2;
            j++;
            twos--;
        }
    }
}