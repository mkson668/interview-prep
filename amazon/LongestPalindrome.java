class LongestPalindrome {
    public static void main(String[] args) {
        String longest = findLongestPalin("vaomxdtiuwqlwhgutkhxxhccsgvyoaccuicgybnqnslogtqhblegfudagpxfvjdacsxgevvepuwthdtybgflsxjdmmfumyqgpxatvdypjmlapccaxwkuxkilqqgpihyepkilhlfkdrbsefinitdcaghqmhylnixidrygdnzmgubeybczjceiybowglkywrpkfcwpsjbkcpnvfbxnpuqzhotzspgebptnhwevbkcueyzecdrjpbpxemagnwmtwikmkpqluwmvyswvxghajknjxfazshsvjkstkezdlbnkwxawlwkqnxghjzyigkvqpapvsntojnxlmtywdrommoltpbvxwqyijpkirvndwpgufgjelqvwffpuycqfwenhzrbzbdtupyutgccdjyvhptnuhxdwbmdcbpfvxvtfryszhaakwshrjseonfvjrrdefyxefqfvadlwmedpvnozobftnnsutegrtxhwitrwdpfienhdbvvykoynrsbpmzjtotjxbvemgoxreiveakmmbbvbmfbbnyfxwrueswdlxvuelbkrdxlutyukppkzjnmfmclqpkwzyylwlzsvriwomchzzqwqglpflaepoxcnnewzstvegyaowwhgvcwjhbbstvzhhvghigoazbjiikglbqlxlccrwqvyqxpbtpoqjliziwmdkzfsrqtqdkeniulsavsfqsjwnvpprvczcujihoqeanobhlsvbzmgflhykndfydbxatskf");
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
                if (isPalindrome(subStr)) {
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
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String reverseSb = sb.toString();
        return reverseSb.equals(s);
    }
}