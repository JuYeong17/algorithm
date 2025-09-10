import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static int[] K = new int[45];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] M = new int[N];
    for (int i= 0; i < 45;i++){
      K[i] = (i+1) * (i+2)/2;
    }
    for(int i=0;i<N;i++){
      M[i]=Integer.parseInt(br.readLine());
      System.out.println(e(M[i]));
    }
  }
  private static int e(int n){
    for(int i=0; i<45;i++){
      for(int j=i;j<45;j++){
        for(int k=j; k<45;k++){
          if(K[i] + K[j] +K[k] == n) return 1;
        }
      }
    }
    return 0;
  }
}
