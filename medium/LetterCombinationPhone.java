import java.util.*;

class LetterCombinationPhone {
    public static void main(String[] args) {
        List<String> ret = letterCombinations("");
        System.out.println(ret);
    }

    public static List<String> letterCombinations(String digits) {
        Map<Character, String> hm = new HashMap<>();
        Queue<String> que = new LinkedList<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        for (int i = 0; i < digits.length(); i++) {
            if (que.isEmpty()) {
                String first = hm.get(digits.charAt(i));
                for (int j = 0; j < first.length(); j++) {
                    que.add(first.substring(j, j + 1));
                }
            } else {
                int qSize = que.size();
                String numStr = hm.get(digits.charAt(i));
                while (qSize > 0) {
                    String s = que.remove();
                    for (int k = 0; k < numStr.length(); k++) {
                        que.add(s + numStr.charAt(k));
                    }
                    qSize--;
                }
            }
        }
        List<String> currList = new ArrayList<>(que);
        return currList;
    }
}