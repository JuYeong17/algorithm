import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> q= new LinkedList<>();
        q.add(begin);
        int result =0;
        boolean[] visited = new boolean[words.length];
        while(!q.isEmpty()){
            int sizeQ = q.size();
            for(int k=0;k<sizeQ;k++){
                String current = q.poll();
                if(current.equals(target)) return result;
                for (int j = 0; j < words.length; j++) {
                    if(visited[j]) continue;
                    int count = 0;
                    for(int i=0;i<current.length();i++){
                        if(current.charAt(i) != words[j].charAt(i)){
                            count ++;
                    }
                }
                if(count ==1){
                    visited[j] = true;
                    q.add(words[j]);
                }
                }
            }
            result++;
        }
        return 0;
    } 
}