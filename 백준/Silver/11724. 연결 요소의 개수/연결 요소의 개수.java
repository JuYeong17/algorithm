import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int[][] arr;
  static boolean[] visited;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    arr = new int[N + 1][N + 1];
    for(int i=0;i< M; i++){
      String[] input2 = br.readLine().split(" ");
      int a = Integer.parseInt(input2[0]);
      int b = Integer.parseInt(input2[1]);

      arr[a][b] = 1;
      arr[b][a] = 1;
    }
    visited = new boolean[N + 1];
    int result =0;

    for(int i = 1; i<N+1;i++){
      if (!visited[i]) {
        dfs(i);
        result++;
      }
    }
    System.out.println(result);
  }

  private static void dfs(int node) {
    visited[node] = true;
    for(int i=1;i<N+1;i++){
      if (!visited[i] && arr[node][i] == 1) {
        dfs(i);
      }
    }

  }
}
