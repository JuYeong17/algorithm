class Solution {
    int max = 0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        int current = k;
        int count = 0;
        visited = new boolean[dungeons.length];
        dfs(current, count,dungeons);
        return max;
    }
    void dfs(int current, int count, int[][] dungenons){
        max = Math.max(max, count);
        for (int i=0;i<dungenons.length;i++){
            if(!visited[i] && current >= dungenons[i][0]){
                visited[i] = true;
                dfs(current - dungenons[i][1],count+1,dungenons);
                visited[i] = false;
            }
        }
    }
}