import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static boolean[][] visited;
  static boolean[][] rgvisited;

  static Queue<int[]> q;
  static Queue<int[]> rgq;
  static String[][] input;
  static String[][] rginput;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    input = new String[N][N];
    rginput = new String[N][N];
    visited = new boolean[N][N];
    rgvisited = new boolean[N][N];
    q = new LinkedList<>();
    rgq = new LinkedList<>();
    for(int i=0;i<N;i++){
      String[] color= br.readLine().split("");
      for(int j=0;j<N;j++){
        input[i][j] = color[j];
        rginput[i][j] = color[j];
        if(Objects.equals(rginput[i][j], "G")){
          rginput[i][j] = "R";
        }
      }
    }
    int count=1;
    q.add(new int[]{0,0});
    visited[0][0] = true;
    bfs();

    int rgcount=1;
    rgq.add(new int[]{0,0});
    rgvisited[0][0] = true;
    rgbfs();

    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(!visited[i][j]){
          q.add(new int[]{i,j});
          visited[i][j] = true;
          bfs();
          count++;
        }
        if(!rgvisited[i][j]){
          rgq.add(new int[]{i,j});
          rgvisited[i][j] = true;
          rgbfs();
          rgcount++;
        }
      }
    }
    System.out.print(count+" "+rgcount);
  }
  static void bfs(){
    int[] dx= {-1,1,0,0};
    int[] dy = {0,0,1,-1};

    while(!q.isEmpty()){
      int[] cur= q.poll();
      int x = cur[0];
      int y= cur[1];

      for(int i=0;i<4;i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx < 0 || ny < 0 || nx >=N ||ny>=N) continue;
        if(!visited[nx][ny] && Objects.equals(input[x][y], input[nx][ny])){
          q.add(new int[]{nx,ny});
          visited[nx][ny] = true;
        }
      }
    }
  }
  static void rgbfs(){
    int[] dx= {-1,1,0,0};
    int[] dy = {0,0,1,-1};

    while(!rgq.isEmpty()){
      int[] cur= rgq.poll();
      int x = cur[0];
      int y= cur[1];

      for(int i=0;i<4;i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx < 0 || ny < 0 || nx >=N ||ny>=N) continue;
        if(!rgvisited[nx][ny] && Objects.equals(rginput[x][y], rginput[nx][ny])){
          rgq.add(new int[]{nx,ny});
          rgvisited[nx][ny] = true;
        }
      }
    }
  }
}