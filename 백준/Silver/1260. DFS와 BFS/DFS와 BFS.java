import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int[][] arr;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    int V = Integer.parseInt(input[2]);

    arr = new int[N + 1][N + 1];
    for(int i=0;i< M; i++){
      String[] input2 = br.readLine().split(" ");
      int a = Integer.parseInt(input2[0]);
      int b = Integer.parseInt(input2[1]);

      arr[a][b] = 1;
      arr[b][a] = 1;
    }
    visited = new boolean[N + 1];
    dfs(V);
    System.out.println();
    visited = new boolean[N + 1];
    bfs(V);
  }

  private static void dfs(int v) {
    visited[v] = true;
    System.out.print(v + " ");

    if (v > arr.length - 1) {
      return;
    }
    for(int node=1; node< arr.length; node ++){
      if (arr[v][node] == 1 && !visited[node]) {
        dfs(node);
      }
    }
  }

  private static void bfs(int v) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(v);
    visited[v] = true;
    System.out.print(v + " ");

    while (!queue.isEmpty()) {
      int temp = queue.poll();
      for(int node= 1;node<arr.length;node++){
        if (arr[temp][node] == 1 && visited[node] == false) {
          queue.add(node);
          visited[node] = true;
          System.out.print(node + " ");
        }
      }
    }
  }
}
