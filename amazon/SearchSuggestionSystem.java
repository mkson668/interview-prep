import java.util.*;

class SearchSuggestionSystem {

    public static void main(String[] args) {
        String[] inputProduct = new String[5];
        inputProduct[0] = "mobile";
        inputProduct[1] = "mouse";
        inputProduct[2] = "moneypot";
        inputProduct[3] = "monitor";
        inputProduct[4] = "mousepad";
        List<List<String>> ret = suggestedProducts(inputProduct, "mouse");
        System.out.println(ret);
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // base case
        Arrays.sort(products);
        String[] productsClone = products.clone();
        List<List<String>> results = new ArrayList<>();
        if (products.length == 0 || searchWord == "") {
            return results;
        }

        for(int i = 1; i <= searchWord.length(); i++) {
            String searchWordSubStr = searchWord.substring(0, i);
            ArrayList<String> matches = new ArrayList<>();
            for (String prod: products) {
                if (i <= prod.length()) {
                    String prodSubString = prod.substring(0, i);
                    if (prodSubString.equals(searchWordSubStr) && matches.size() < 3) {
                        matches.add(prod);
                    }
                }
            }
            // by default ascending order only add if contains stuff
            /* if (matches.size() != 0) {
                Collections.sort(matches);
                results.add(matches);
            } */
            results.add(matches);
        }
        return results;
    }
}