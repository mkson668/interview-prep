import java.util.*;


public class GenerateParethesis {
    public static void main(String[] args) {
        List<String> allCombinations = generateParenthesis(3);
        System.out.println(allCombinations);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        // must start with open bracket or else it can never close
        findAllParenthesisCombinations(ret, 0, 0, n, "");
        // List<String> ret1 = new ArrayList<>();
        // ret1.addAll(ret);
        return ret;
    }

    public static void findAllParenthesisCombinations(List<String> store, int openbrkt, int closebrkt, int n, String currStr) {
        if (openbrkt + closebrkt == 2*n) {
            store.add(currStr);
            return;
        } else {
            if (currStr == "") {
                currStr += "(";
                findAllParenthesisCombinations(store, openbrkt + 1, closebrkt, n, currStr);
            } else {
                if (openbrkt >= closebrkt) {
                    if (openbrkt == closebrkt) {
                        findAllParenthesisCombinations(store, openbrkt + 1, closebrkt, n, currStr + "(");
                    } else if (openbrkt == n) {
                        currStr += ")";
                        findAllParenthesisCombinations(store, openbrkt, closebrkt + 1, n, currStr);
                    } else {
                        findAllParenthesisCombinations(store, openbrkt, closebrkt + 1, n, currStr + ")");
                        findAllParenthesisCombinations(store, openbrkt + 1, closebrkt, n, currStr + "(");
                    }
                } 
            }
        }
    }
}