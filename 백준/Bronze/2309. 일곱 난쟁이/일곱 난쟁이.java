import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = new int[9];
    int total = 0;
    for(int i=0;i<9;i++){
      input[i] = Integer.parseInt(br.readLine());
      total += input[i];
    }
    boolean found = false;

    for(int i=0;i< 9;i++){
      for(int j=1;j< 9;j++){
        int result = input[i] + input[j];
        if(result == total - 100){
          input[i] = 0;
          input[j] = 0;
          found = true;
          break;
        }
      }
      if(found) break;
    }
    Arrays.sort(input);
    for(int i=2;i<9;i++){
      System.out.println(input[i]);
    }
  }
}