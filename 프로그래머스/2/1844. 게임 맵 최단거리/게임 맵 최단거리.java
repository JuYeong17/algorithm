import java.util.*;
//큐에 출발 순서 넣기 -> 출발순서에서 벽이 없는 위치 큐에 넣기 -> 해당 사이클 반복 후 n,m 위치에 있는 곳에 도달하면 distance 반환


class Solution {
    public int solution(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        int[] dx ={0,-1,1,0};
        int[] dy ={1,0,0,-1};
        
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int d = current[2];
            if(x == n-1 && y== m-1){
                return d;
            }
            for(int i=0;i<dx.length;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(maps[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny,d+1});                        
                    }
                }
            }

        }
        return -1;
    }
}