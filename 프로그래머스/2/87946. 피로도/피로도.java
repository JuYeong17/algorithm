class Solution {
    int count = 0;
    boolean[] visited;
    int max=0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, count, dungeons);
        return max;
    }
    void dfs(int current, int count, int[][] dungeons){
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && current >= dungeons[i][0]){
                visited[i]= true;
                dfs(current - dungeons[i][1], count +1, dungeons);
                visited[i]=false;
            }
            if(count > max) max = count;
        }
    }
}