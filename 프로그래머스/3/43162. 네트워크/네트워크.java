class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,computers);
                count++;   
            }
        }
        return count;
    }
    void dfs(int index, boolean[] visited, int[][] computers){
        for(int i=0; i<visited.length;i++){
            if(!visited[i] && computers[index][i] == 1){
                visited[i]=true;
                dfs(i,visited,computers);
            }
        }
    }
}