import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> total = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            total.put(genres[i], total.getOrDefault(genres[i],0)+plays[i]);
        }
        List<String> keySet = new ArrayList<>(total.keySet());
        keySet.sort((o1, o2) -> total.get(o2).compareTo(total.get(o1)));
        List<Integer> result = new ArrayList<>();

        for(String key: keySet){
            HashMap<Integer, Integer> result1 = new HashMap<>();

            for(int i=0;i<genres.length;i++){
                if(key.equals(genres[i])){
                    result1.put(i,plays[i]);
                }
            }
            List<Integer> keySet2 = new ArrayList<>(result1.keySet());
            keySet2.sort((o1, o2) -> result1.get(o2).compareTo(result1.get(o1)));
            for (int i = 0; i < keySet2.size() && i < 2; i++) {
                result.add(keySet2.get(i));
             }
        }
    return result.stream().mapToInt(i -> i).toArray();
}
}