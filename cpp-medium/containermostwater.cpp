#include <vector>

class Solution {
public:
// O(n^2)
    static int maxArea(std::vector<int>& height) {
        if (height.size() == 0) return 0;
        int currMax = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i; j < height.size(); j++) {
                int maxHeight = height[i] > height[j] ? height[j] : height[i];
                int vol = maxHeight * (j - i);
                if (vol > currMax) {
                    currMax = vol;
                }
            }
        }
        return currMax;
    }

// O(n)
    static int maxArea0(std::vector<int>& height) {
        if (height.size() == 0) return 0;
        int currMax = 0;
        int left = 0, right = height.size() - 1;
        while (left < right) {
            int maxHeight;
            int width = (right - left);
            if (height[left] > height[right]) {
                maxHeight = height[right];
                right--;
            } else {
                maxHeight = height[left];
                left++;
            }
            int volume = maxHeight * width;
            if (volume > currMax) {
                currMax = volume;
            } 
        }
        return currMax;
    }
};


int main() {
    std::vector<int> vec{1,8,6,2,5,4,8,3,7};
    int ret = Solution::maxArea0(vec);
};