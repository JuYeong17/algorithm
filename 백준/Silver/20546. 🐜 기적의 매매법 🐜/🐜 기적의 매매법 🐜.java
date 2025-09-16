import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    int jun=0;
    int seong=0;
    int junpay =m;
    int seongpay=m;
    String[] input = br.readLine().split(" ");
    int[] numbers = new int[input.length];
    for (int j = 0; j < input.length; j++) {
      numbers[j] = Integer.parseInt(input[j]);
    }
    int rising =0;
    int deg=0;
    for(int i=0;i<14;i++) {
      if (junpay >= numbers[i]) {
        jun += junpay / numbers[i];
        junpay = junpay % numbers[i];
      }

      if (i >= 1) {
        if (numbers[i] > numbers[i - 1]) {
          rising++;
          deg = 0;
          if (rising >= 3 && seong > 0) {
            seongpay += numbers[i] * seong;
            seong = 0;
          }
        } else if (numbers[i] < numbers[i - 1]) {
          deg++;
          rising = 0;
          if (deg >= 3 && seongpay > 0) {
            seong += seongpay / numbers[i];
            seongpay %= numbers[i];
          }
        } else {
          rising = 0;
          deg = 0;
        }
      }
    }
    int junResult = junpay + jun *numbers[13];
    int seongResult = seongpay + seong * numbers[13];
    if (junResult > seongResult) {
      System.out.println("BNP");
    } else if (junResult < seongResult) {
      System.out.println("TIMING");
    } else {
      System.out.println("SAMESAME");
    }

  }
}
