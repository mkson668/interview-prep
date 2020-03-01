import java.util.*;

class LongestSubStrNoDuplicate {
    public static void main(String[] args) {
        String ss = "b";
        int count = lengthOfLongestSubstring(ss);
        System.out.println(count);
    }

    public static int lengthOfLongestSubstring(String s) {
        int currLongest = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> charSet = new HashSet<>();
            int counter = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!charSet.contains(c)) {
                    // keep adding
                    charSet.add(c);
                    counter += 1;
                    if (counter > currLongest) {
                        currLongest = counter;
                    }
                } else {
                    // reset 
                    break;
                }
            }
        }
        return currLongest;
    }
}