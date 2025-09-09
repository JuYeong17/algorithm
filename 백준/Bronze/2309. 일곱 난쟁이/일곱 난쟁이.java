import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] M = new int[9];
    int result = 0;
    for (int i= 0; i<9;i++){
      M[i] =  Integer.parseInt(br.readLine());
      result += M[i];
    }
    for(int i=0;i<8;i++){
      for(int j= i+1; j<9;j++){
        if(result -M[i] -M[j] ==100){
          M[i] = 0;
          M[j] = 0;
          Arrays.sort(M);
          for( int k=2;k<9;k++){
            System.out.println(M[k]);
          }
          return;
        }
      }
    }
  }
}
