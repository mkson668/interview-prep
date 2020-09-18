#include <string>
#include <stack>

class Solution {
public:
    static bool isValid(std::string s) {
        if (s.length() == 0) return true;
        std::stack<char> stk;
        bool isValidStr = true;
        for (int i = 0; i < s.length(); i++) {
            // entire thing is already wrong just break out
            if (!isValidStr) break;
            char c = s[i];
            if (c == '(' || c == '[' || c == '{') {
                stk.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                // if the stack is already empty but there are extra trailing closing brackets it is wrong
                // {}()[]]
                if (stk.empty()) {
                    isValidStr = false;
                    continue;
                }
                char top = stk.top();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    stk.pop();
                    continue;
                } else {
                    isValidStr = false;
                }
            } else {
                // anything not a bracket invalidates the string
                // {}a()
                isValidStr = false;;
            }
        }
        // check if opening brackets are not closed
        if (!stk.empty()) isValidStr = false;
        return isValidStr;
    }
};

int main() {
    bool ret = Solution::isValid("{}()[]]]]");
}