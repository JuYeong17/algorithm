import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length;j++){
                if(maps[i][j] == 0){
                    visited[i][j] = true;
                }
                else visited[i][j] = false;
            }
        }
    
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        q.add(new int[]{0, 0, 1});
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            for(int i=0;i<dx.length;i++){
                int nx = x+ dx[i];
                int ny = y+ dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny, distance + 1});
                    }
                }
            }
            if (x == n - 1 && y == m - 1) {
                return distance;
            }
        }
        return -1;
    }
}