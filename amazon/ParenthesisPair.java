import java.util.*;

class ParenthesisPair {
    public static void main(String[] args) {
        String input = "){";
        Boolean retVal = checkValidParentthesis(input);
        System.out.println(retVal);
    }

    public static Boolean checkValidParentthesis(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }
        Boolean valid = true;
        Stack<Character> sk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp == '[' || temp == '{' || temp == '(') {
                sk.add(temp);
            } else {
                if (!sk.isEmpty()) {
                    char topSk = sk.pop();
                    switch (topSk) {
                        case '(':
                            if (temp != ')') {
                                valid = false;
                            } 
                            break;
                        case '[':
                            if (temp != ']') {
                                valid = false;
                            }
                            break;
                        case '{':
                            if (temp != '}') {
                                valid = false;
                            }
                            break;
                        default:
                        // this means we have added something not a bracket or def wrong;
                            valid = false;
                            break;
                    }
                } else {
                    // exists closing bracket but no more opening brackets
                    valid = false;
                    break;
                }
                if (!valid) {
                    // encountered wrong quit loop
                    break;
                }
            }
        }
        if (!sk.isEmpty()) {
            valid = false;
        }
        return valid;
    }

    public static boolean checkValidParenthesisv2(String s) {
        HashMap<Character, Character> hm = new HashMap<>();
        Stack<Character> sk = new Stack<>();
        hm.put('}', '{');
        hm.put(')', '(');
        hm.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hm.containsValue(c)) {
                // open bracket add to stack
                sk.add(c);
            } else {
                // its a close bracket
                if (sk.empty()) {
                    // if empty thats bad cause not able to find opening bracket to match
                    return false;
                } else {
                    // if not empty stack get the char at top of stack 
                    char topC = sk.pop();
                    if (topC == hm.get(c)) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        if (!sk.empty()) {
            return false;
        }
        return true;
    }
}