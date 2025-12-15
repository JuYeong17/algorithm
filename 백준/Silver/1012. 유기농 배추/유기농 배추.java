import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int[][] graph;

  static boolean[][] visited;
  static void dfs(int x, int y){
    visited[x][y] = false;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    for(int d=0;d<4;d++){
      int nx= x+dx[d];
      int ny = y+dy[d];
      if(nx >= 0 && nx < graph.length && ny>=0 && ny<graph[0].length){
        if(graph[nx][ny] == 1 && visited[nx][ny]){
          dfs(nx,ny);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      StringTokenizer input = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(input.nextToken());
      int N = Integer.parseInt(input.nextToken());
      int K = Integer.parseInt(input.nextToken());
      graph = new int[M][N];
      visited = new boolean[M][N];
      for (int i = 0; i < K; i++) {
        StringTokenizer input2 = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(input2.nextToken());
        int y = Integer.parseInt(input2.nextToken());
        graph[x][y] = 1;
        visited[x][y] = true;
      }
      int count = 0;
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          if (visited[i][j]) {
            dfs(i, j);
            count++;
          }
        }
      }
      System.out.println(count);
    }
  }
}