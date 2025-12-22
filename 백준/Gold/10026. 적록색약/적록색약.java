import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static boolean[][] visited;
  static String[][] input;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    input = new String[N][N];
    visited = new boolean[N][N];
    for(int i=0;i<N;i++){
      String[] color= br.readLine().split("");
      for(int j=0;j<N;j++){
        input[i][j] = color[j];
      }
    }
    int count=0;
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(!visited[i][j]){
          visited[i][j] = true;
          bfs(i,j);
          count++;
        }
      }
    }
    visited = new boolean[N][N];

    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(Objects.equals(input[i][j],"G")){
          input[i][j] ="R";
        }
      }
    }
    int rgcount=0;
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(!visited[i][j]){
          visited[i][j] = true;
          bfs(i,j);
          rgcount++;
        }
      }
    }
    System.out.print(count+" "+ rgcount);
  }
  static void bfs(int i, int j){
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{i,j});
    int[] dx= {-1,1,0,0};
    int[] dy = {0,0,1,-1};

    while(!q.isEmpty()){
      int[] cur= q.poll();
      int x = cur[0];
      int y= cur[1];

      for(int k=0;k<4;k++){
        int nx = x + dx[k];
        int ny = y + dy[k];
        if(nx < 0 || ny < 0 || nx >=N ||ny>=N) continue;
        if(!visited[nx][ny] && input[x][y].equals(input[nx][ny])){
          visited[nx][ny] = true;
          q.add(new int[]{nx,ny});
        }
      }
    }
  }
}