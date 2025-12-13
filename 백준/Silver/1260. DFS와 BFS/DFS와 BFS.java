import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  static void dfs(int v){
    visited[v] =true;
    System.out.print(v +" ");
    for(int next: graph[v]){
      if(!visited[next]) dfs(next);
    }
  }
  static void bfs(int v){
    boolean[] visitedBfs = new boolean[graph.length];
    Queue<Integer> q= new LinkedList<>();
    q.add(v);
    visitedBfs[v] = true;
    while(!q.isEmpty()){
      int x = q.poll();
      System.out.print(x + " ");
      for(int next: graph[x]){
        if(!visitedBfs[next]){
          visitedBfs[next] =true;
          q.add(next);
        }
      }
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer input = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(input.nextToken());
    int M = Integer.parseInt(input.nextToken());
    int startV = Integer.parseInt(input.nextToken());
    graph = new ArrayList[N+1];
    for(int i=1;i<=N;i++) graph[i]=new ArrayList<>();
    for(int i=0;i<M;i++){
      StringTokenizer input2 = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(input2.nextToken());
      int b = Integer.parseInt(input2.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }
    for(int i=1;i<=N;i++) Collections.sort(graph[i]);
    visited = new boolean[N+1];
    dfs(startV);
    System.out.println();
    bfs(startV);
  }
}