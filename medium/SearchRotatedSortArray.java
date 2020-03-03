class SearchRotatedSortArray {
    public static void main(String[] args) {
        int[] ar = new int[]{4,5,6,7,0,1,2};
        int ret = search(ar, 6);
        System.out.println(ret);
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0;
        int right = nums.length - 1;
        // find smallest index
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // this covers less tha or equal
                right = mid;
            }
        }
        // think left and right will converge to same index
        int startIndex = left;
        left = 0;
        right = nums.length - 1;
        // select the correct partition first
        if (target >= nums[startIndex] && nums[right] >= target) {
            left = startIndex;
        } else {
            right = startIndex - 1;
        }
        // perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                // <
                right = mid - 1;
            }
        }
        return -1;
    }

}