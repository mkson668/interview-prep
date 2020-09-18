#include <iostream>
#include <string>
#include <vector>
#include <set>

// brute forcing solution
class LongestSubstring {
    public:
    static int lengthOfLongestSubstring(std::string s) {
        std::string currLongestStr = "";
        std::set<std::string> currChars;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char insertChar = s.at(j);
                if (currChars.insert(insertChar).second == false) {
                    break;
                }
                std::string currStr = s.substr(i,j-i+1);
                if (currStr.size() > currLongestStr.size()) {
                    currLongestStr = currStr;
                }
            }
            currChars.clear();
        }
        return currLongestStr.size();
    } 
};

int main()
{
    int retSize = LongestSubstring::lengthOfLongestSubstring("abcabcbb");
    std::cout << "end" << std::endl;
    return 0;
}
