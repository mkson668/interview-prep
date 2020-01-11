import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SubstringKSizeKDistinct {
    public static void main(String[] args) {
        List<String> ret = new ArrayList<>();
        String inputS = "awaglknagawunagwkwagl";
        ret = substringKK(inputS, 4);
        System.out.println(ret);
    }

    public static List<String> substringKK(String s, int k) {
        List<String> store = new ArrayList<>();
        for (int i = 0, j = k; i <= s.length() && j <= s.length(); i++, j++) {
            String substr = s.substring(i, j);
            if (checkUniqueLetterStr(substr) && !store.contains(substr)) {
                store.add(substr);
            }
        }
        return store;
    }

    public static Boolean checkUniqueLetterStr(String s) {
        Map<Character, Boolean> uniqueMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (uniqueMap.get(s.charAt(i)) == null) {
                uniqueMap.put(s.charAt(i), true);
            } else {
                return false;
            }
        }
        return true;
    }

    public static List<String> permutationsKK(String s, int k) {
        List<String> allStrings = new ArrayList<>();
        permutationsKKGenerate(s, k, allStrings, "");
        System.out.println(allStrings);
        return allStrings;
    }

    public static void permutationsKKGenerate(String str, int k, List<String> store, String currStr) {
        if (str.length() == 0) {
            return;
        }
        // if the combination has reached length k and has not been stored yet
        if (currStr.length() == k && !store.contains(currStr)) {
            store.add(currStr);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            Character temp = str.charAt(i);
            String tempStr = Character.toString(temp);
            if (!currStr.contains(tempStr)) {
                String updateCurrStr = currStr + tempStr;
                permutationsKKGenerate(str, k, store, updateCurrStr);
            } 
        }
    }
}