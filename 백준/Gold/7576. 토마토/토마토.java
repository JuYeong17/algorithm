import java.io.*;
import java.util.*;

public class Main {

  static Queue<int[]> q = new LinkedList<int[]>();
  static int[][] input;
  static int N,M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    input = new int[N][M];
    for (int i = 0; i < N; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        input[i][j] = Integer.parseInt(st2.nextToken());
      }
    }
    int count=0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (input[i][j] == 1) {
          q.add(new int[]{i, j});
        }
      }
    }
    bfs();
    int answer=0;
    for(int i=0;i<N;i++){
      for(int j=0;j<M;j++){
        if(input[i][j]==0){
          System.out.println(-1);
          return;
        }
        answer = Math.max(answer,input[i][j]);
      }
    }
    System.out.println(answer -1 );
  }

  static void bfs() {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0];
      int y = cur[1];
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        if(input[nx][ny]==0) {
          input[nx][ny] = input[x][y] +1;
          q.add(new int[]{nx, ny});
        }
      }
    }
  }
}