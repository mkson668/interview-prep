import java.util.*;

class FavouriteGenre {
    public static void main(String[] args) {
        Map<String, List<String>> map1 = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();
        List<String> input1L = new ArrayList<>(Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        List<String> input2L = new ArrayList<>(Arrays.asList("song5", "song6", "song7"));
        map1.put("David", input1L);
        map1.put("Emma", input2L);
        /* List<String> input3L = new ArrayList<>(Arrays.asList("song1", "song3"));
        List<String> input4L = new ArrayList<>(Arrays.asList("song7"));
        List<String> input5L = new ArrayList<>(Arrays.asList("song2", "song4"));
        List<String> input6L = new ArrayList<>(Arrays.asList("song5", "song6"));
        List<String> input7L = new ArrayList<>(Arrays.asList("song8", "song9"));
        map2.put("Rock", input3L);
        map2.put("Dubstep", input4L);
        map2.put("Techno", input5L);
        map2.put("Pop", input6L);
        map2.put("Jazz", input7L); */

        Map<String, List<String>> result = findFavouriteGenre(map1, map2);
        System.out.println(result);
    }

    public static Map<String, List<String>> findFavouriteGenre(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        Map<String, List<String>> ret = new HashMap<>();
        Map<String, String> songMap = new HashMap<>();
        // store into hashmap for easy access of song genre types
        for (String genre: songGenres.keySet()) {
            List<String> oneGenreList = songGenres.get(genre);
            for (String s: oneGenreList) {
                songMap.put(s, genre);
            }
        }

        for (String user: userSongs.keySet()) {
            int currHighestGenre = 0;
            List<String> userSongList = userSongs.get(user);
            Map<String, Integer> counter = new HashMap<>();
            for (String song: userSongList) {
                String genre;
                if (songMap.containsKey(song)) {
                    genre = songMap.get(song);
                } else {
                    continue;
                }
                if (counter.get(genre) == null) {
                    counter.put(genre, 1);
                    if (currHighestGenre == 0) {
                        currHighestGenre = 1;
                    }
                } else {
                    int curr = counter.get(genre);
                    counter.put(genre, curr + 1);
                    if (curr + 1 >= currHighestGenre) {
                        currHighestGenre = curr + 1;
                    }
                }
            }
            List<String> genreLst = new ArrayList<>();
            for (String gr: counter.keySet()) {
                if (counter.get(gr) == currHighestGenre) {
                    genreLst.add(gr);
                }
            }
            ret.put(user, genreLst);
        }
        return ret;
    }
}