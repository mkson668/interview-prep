#include <limits>

class Solution {
public:
    static int reverse(int x) {
        int reverseInt = 0;
        int currDigit = 0;
        int i = x;
        int currIter = 0;
        while (i != 0) {
            currDigit = i % 10;
            reverseInt += 10^currIter * currDigit;
            i = i / 10;
            currIter++;
        }
        return reverseInt;
    }
};

int main() {
    int ret = Solution::reverse(123);
}