import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ReorderOfLogs {
    public static void main(String[] args) {
        String[] input = new String[]{
            "dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"
        };
        String[] ret = reorderLogFiles(input);
        System.out.println(ret);
    }

    public static String[] reorderLogFiles(String[] logs) {
        
        ArrayList<String> numberLogs = new ArrayList<>();
        ArrayList<String> letterLogs = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            Boolean checkNumOrChar = Character.isDigit(logs[i].charAt(5));
            if (checkNumOrChar) {
                numberLogs.add(logs[i]);
            } else {
                letterLogs.add(logs[i]);
            }
        }
        String[] numlogsArr = new String[numberLogs.size()];
        numlogsArr = numberLogs.toArray(numlogsArr);
        String[] letterlogsArr = new String[letterLogs.size()];
        letterlogsArr = letterLogs.toArray(letterlogsArr);
        Arrays.sort(numlogsArr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String sub1 = s1.substring(5);
                String sub2 = s2.substring(5);
                return sub2.compareTo(sub1);
            }
        });

        Arrays.sort(letterlogsArr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String sub1 = s1.substring(5);
                String sub2 = s2.substring(5);
                return sub1.compareTo(sub2);
            }
        });
        ArrayList<String> l1 = new ArrayList<>(Arrays.asList(letterlogsArr));
        l1.addAll(Arrays.asList(numlogsArr));
        String[] reorderedLogs = new String[l1.size()];
        reorderedLogs = l1.toArray(reorderedLogs);
        return reorderedLogs;
    }
}