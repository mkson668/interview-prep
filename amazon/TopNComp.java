import java.util.*;
import java.util.Map.Entry;

class TopNComp implements Comparable<Entry>{
    public static void main(String[] args) {
        System.out.println("noice");
        ArrayList<String> competitors = new ArrayList<String>(Arrays.asList("newshop", "shopnow", "afshion", "fashionbeats", "mymarket", "tcellular"));
        ArrayList<String> reviews = new ArrayList<String>(Arrays.asList("newshop is providing good services in the city; everyone should use newshop", 
        "best services by newshop", 
        "fashionbeats has great services in the city", 
        "i am proud to have fashionbeats", 
        "mymarket has awesome services fashionbeats", 
        "thanks newshop for the quick delivery")); 
        ArrayList<String> ret = findTopNCompetitors(6, 2, competitors, 6, reviews);
    }
    
    public static final Comparator<Entry<String, Integer>> descendComparator = new Comparator<Entry<String, Integer>>(){
    
        public int compare(Entry o1, Entry o2) {
            Integer v1 = (int) o1.getValue();
            Integer v2 = (int) o2.getValue();
            int vComp = v2 - v1;

            if (vComp != 0) {
                return vComp;
            }

            String s1 = (String) o1.getKey();
            String s2 = (String) o2.getKey();
            return s1.compareTo(s2);
        }
    };

    public static final Comparator<Entry<String, Integer>> nameComparator = new Comparator<Entry<String,Integer>>(){
    
        public int compare(Entry o1, Entry o2) {
            String s1 = (String) o1.getKey();
            String s2 = (String) o2.getKey();
            return s1.compareTo(s2); 
        }
    };

    public static ArrayList<String> findTopNCompetitors(int numCompetitors, 
                                                        int topNCompetitiors, 
                                                        ArrayList<String> competitors, 
                                                        int numReviews, 
                                                        ArrayList<String> reviews) {
        ArrayList<String> topCompetitors = new ArrayList<>();
        HashMap<String, Integer> topCompetitorMap = new HashMap<>();
        for (int i = 0; i < competitors.size(); i++) {
            int occurances = 0;
            String currCompetitorStr = competitors.get(i);
            for (int j = 0; j < reviews.size(); j++) {
                String currReviewStr = reviews.get(j);
                if (currReviewStr.contains(currCompetitorStr)) {
                    occurances += 1;
                }
            }
            topCompetitorMap.put(currCompetitorStr, occurances);
        }
        Set<Entry<String, Integer>> topCompetitorSet = topCompetitorMap.entrySet();
        List<Entry<String, Integer>> topCompetitorList = new ArrayList<Entry<String, Integer>>(topCompetitorSet);
        Collections.sort(topCompetitorList, descendComparator);
        System.out.println(topCompetitorList);
        for (int k = 0; k < topNCompetitiors; k++) {
            topCompetitors.add(topCompetitorList.get(k).getKey());
        }
        return topCompetitors;
    }   
}