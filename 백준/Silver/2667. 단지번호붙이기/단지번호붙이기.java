import java.io.*;
import java.util.*;

public class Main {
  static int[][] graph;
  static boolean[][] visited;
  static List<Integer> result = new ArrayList<>();;
  static int totalN;
  static void dfs(int x, int y){
    visited[x][y] = false;
    int[] dx= {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    for(int i=0;i<4;i++){
      int nx= x+dx[i];
      int ny= y+dy[i];
      if(nx >= 0 && nx<graph.length && ny >= 0&& ny<graph[0].length){
        if(graph[nx][ny] == 1 && visited[nx][ny]){
          totalN++;
          dfs(nx,ny);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    graph = new int[N][N];
    visited= new boolean[N][N];
    for(int i=0;i<N;i++){
      String[] M = br.readLine().split("");
      for(int j=0;j<N;j++){
        graph[i][j] = Integer.parseInt(M[j]);
      }
    }

    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(graph[i][j]== 1){
          visited[i][j] = true;
        }
      }
    }
    int total=0;

    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++) {
        if (visited[i][j]) {
          totalN = 1;
          dfs(i, j);
          result.add(totalN);
          total++;
        }
      }
    }
    Collections.sort(result);
    System.out.println(total);
    for(int res: result){
      System.out.println(res);
    }
  }
}