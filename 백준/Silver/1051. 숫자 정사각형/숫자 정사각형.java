import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N,M, ans=Integer.MIN_VALUE;
  static int[][] map;
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    for(int i=0;i<N;i++){
      String str= bf.readLine();
      for(int j =0; j<M;j++){
        map[i][j] = str.charAt(j) - '0';
      }
    }
    int len = Math.min(N,M);

    while(len > 1){
      for ( int i=0; i<=N-len;i++){
        for ( int j= 0; j<=M-len;j++){
          int num = map[i][j];
          if (num == map[i][j + len - 1] && num == map[i + len - 1][j] && num == map[i+len-1][j+len-1]){
            System.out.println(len * len);
            return;
          }
        }
      }
      len--;
    }
    System.out.println(len * len);
  }
}
