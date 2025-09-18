import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<int[]> list = new ArrayList<>();
    int[] dp = new int[n + 2];

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      int T = Integer.parseInt(input[0]);
      int P = Integer.parseInt(input[1]);
      list.add(new int[]{T, P});
    }
    for (int i = n - 1; i >= 0; i--) {
      int T = list.get(i)[0];
      int P = list.get(i)[1];

      if (i + T <= n) {
        dp[i] = Math.max(P + dp[i + T], dp[i + 1]);
      } else {
        dp[i] = dp[i + 1];
      }
    }
    System.out.println(dp[0]);
  }
}
