class Solution {
    boolean[] visited ;
    int count =0;
    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        for(int i=0;i<computers.length;i++){
            if(!visited[i]){
                dfs(i,computers);
                count++;
            }
        }
        return count;
    }
    void dfs(int current, int[][] computers){
        visited[current] = true;
        for(int i=0;i<computers.length;i++){
            if(computers[i][current] == 1 && !visited[i]){
                dfs(i, computers);
            }
        }
    }
}