import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
  public static void main(String[] args) throws IOException {
    DecimalFormat df = new DecimalFormat("0.000");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    int cases = 153;
    int count =0;
    if(N==M){
      count = cases - (10 - N);
      System.out.println(df.format(count / (cases * 1.0)));
    } else{
      for( int i=1; i<=10;i++){
        for(int j=1+i;j<=10;j++) {
          int sum = i + j;
          if (sum % 10 < (N + M) % 10) {
            if (i == N | i == M | j == N | j == M) {
              count += 2;
            } else {
              count += 4;
            }
          }
        }
      }
      System.out.println(df.format(count / (cases *1.0)));
    }
  }
}
