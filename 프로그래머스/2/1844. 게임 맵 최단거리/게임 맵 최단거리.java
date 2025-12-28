import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n= maps.length;
        int m = maps[0].length;
        int[][] visited = new int[n][m];
        Queue<int[]> q= new ArrayDeque<>();
        
        visited[0][0]= 1;
        q.add(new int[]{0,0});
        
        int[] dx= {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        
        while(!q.isEmpty()){
            int[] cur= q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx>=n||ny<0||ny>=m) continue;
                if(visited[nx][ny] !=0 || maps[nx][ny] == 0) continue;
                visited[nx][ny] = visited[x][y]+ 1;

                if(nx == n-1 && ny == m-1){
                    return visited[nx][ny];
                }
                q.add(new int[]{nx,ny});
            }
        }
        return -1;
    }
}
