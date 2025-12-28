import java.util.*;
class Solution {
    static int[][] visited;
    static Queue<int[]> q;
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        q= new LinkedList<>();
        
        visited[0][0]= 1;
        q.add(new int[]{0,0});
        bfs(maps);
        int result = visited[maps.length-1][maps[0].length-1];
        if (result == 0) return -1;
        else return result;
    }
    
    public void bfs(int[][] maps){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        while(!q.isEmpty()){
            int[] cur= q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0;i<4;i++){
                int nx= x + dx[i];
                int ny = y +dy[i];
                if(nx <0||nx>=maps.length||ny<0||ny>=maps[0].length) continue;
                else if(maps[nx][ny]==1 && visited[nx][ny] == 0){
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }

}
