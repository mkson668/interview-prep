#include <vector>
#include <numeric>
#include <algorithm>

class Solution {
public:
    static std::vector<std::vector<int>> combinationSum(std::vector<int>& candidates, int target) {
        std::vector<std::vector<int>> allComb;
        std::vector<int> currComb;
        // sort by ascending
        std::sort(candidates.begin(), candidates.end());
        combinationSumHelper(candidates, target, allComb, currComb, 0);
        return allComb;
    }

    static void combinationSumHelper(std::vector<int>& candidates, int target, std::vector<std::vector<int>>& allComb, std::vector<int> currComb, int startIndex) {
        int sum = std::accumulate(currComb.begin(), currComb.end(), 0);
        if (sum == target) {
            allComb.push_back(currComb);
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.size(); i++) {
            std::vector<int> newComb;
            // copy existing values to new array
            newComb.assign(currComb.begin(), currComb.end());
            newComb.push_back(candidates.at(i));
            //combinationSumHelper(candidates, target, allComb, newComb, i+1);
            combinationSumHelper(candidates, target, allComb, newComb, i);
        }
        return;
    }
};

int main() {
    std::vector<int> values{2,3,6,7};
    std::vector<std::vector<int>> ret = Solution::combinationSum(values, 7);
}