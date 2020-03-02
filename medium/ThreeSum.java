import java.util.*;

class ThreeSum {
    public static void main(String[] args) {
        int[] inputArr = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> out = threeSumOptimal(inputArr);
        System.out.println(out);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> allTriples = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(nums[i]);
                        triple.add(nums[j]);
                        triple.add(nums[k]);
                        Collections.sort(triple);
                        if (!allTriples.contains(triple)) {
                            allTriples.add(triple);
                        }
                    }
                }
            }
        }
        return allTriples;
    }

    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) {
            return new ArrayList<>(res);
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
            int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                }
                else if (sum > 0) k--;
                else if (sum < 0) j++;
            }
        }
        return new ArrayList<>(res);
    }
 
}