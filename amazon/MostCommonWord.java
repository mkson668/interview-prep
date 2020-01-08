import java.util.*;

public class MostCommonWord {
    public static void main(String[] args) {
        String inputPara = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] bannedWords = new String[]{"hit"};
        String ret = findMostCommonWord(inputPara, bannedWords);
        System.out.println(ret);
    }

    public static String findMostCommonWord(String paragraph, String[] banned) {
        String mostCommonWord = "";
        // need to save regex filtered string
        paragraph = paragraph.replaceAll("[!?,';.]", " ");
        paragraph = paragraph.toLowerCase();
        String[] splitPara = paragraph.split("\\s+");
        System.out.println(splitPara);
        Map<String, Integer> countMap = new HashMap<>();
        int currHigh = 0;
        String currHighWord = "";
        List<String> bannedArr = Arrays.asList(banned);
        for (String w: splitPara) {
            if (countMap.containsKey(w)) {
                int temp = countMap.get(w);
                countMap.put(w, ++temp);
            } else {
                countMap.put(w, 1);
            }
            if (countMap.get(w) > currHigh && !bannedArr.contains(w)) {
                currHigh = countMap.get(w);
                currHighWord = w;
            }
        }
        mostCommonWord = currHighWord;
        return mostCommonWord;
    }
}