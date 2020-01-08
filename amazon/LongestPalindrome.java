class LongestPalindrome {
    public static void main(String[] args) {
        String longest = findLongestPalin("aabaa");
        System.out.println(longest);
    }

    public static String findLongestPalin(String s) {
        String longestPalin = "";
        if (s.length() <= 1) {
            return s;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0, k = i; k <= s.length(); j++, k++) {
                String subStr = s.substring(j, k);
                if (isPalindromePivot(subStr)) {
                    if (subStr.length() > longestPalin.length()) {
                        longestPalin = subStr;
                        break;
                    }
                }
            }
        }
        return longestPalin;
    }

    public static boolean isPalindrome(String s) {
        /* String rever = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rever += s.charAt(i);
        }
        return rever.equals(s); */
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String reverseSb = sb.toString();
        return reverseSb.equals(s); 
    }

    public static boolean isPalindromePivot(String s) {
        if (s.length() % 2 != 0) {
            // odd
            int i = s.length()/2;
            int j = s.length()/2;
            while (i >= 0 && j < s.length()) {
                if (!(s.charAt(i) == s.charAt(j))) {
                    return false;
                }
                i-=1;
                j+=1;
            }
        } else {
            // even
            int i = s.length()/2 - 1;
            int j = s.length()/2;
            while (i >= 0 && j < s.length()) {
                if (!(s.charAt(i) == s.charAt(j))) {
                    return false;
                }
                i-=1;
                j+=1;
            }
        }
        return true;
    }

    public static String findLongestPalinV2(String s) {
        StringBuilder longest = new StringBuilder();
        if (s.length() <= 1)
            return s;

        for (int i = 0; i < s.length(); i++) {
            // the i is like the center pivot and we expand in both directions <----i---->
            expand(s, longest, i, i); // odd
            expand(s, longest, i, i + 1); // even
        }

        return longest.toString();
    }

    private static void expand(String s, StringBuilder longest, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                if (j - i + 1 > longest.length()) {
                    longest.delete(0, longest.length());
                    longest.append(s.substring(i, j + 1));
                }
                i--;
                j++;
            } else
            // break because its no longer a possible palinrome
                break;
        }
    }

}