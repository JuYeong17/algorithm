import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    int num =1;
    for(int i=0; i< m;i++){
      String[] input = br.readLine().split(" ");
      int x = Integer.parseInt(input[0]);
      int y = Integer.parseInt(input[1]);

      if (x == num) {
        num =y;
      } else if (y == num) {
        num = x;
      }
    }
    System.out.println(num);
  }
}
