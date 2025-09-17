import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int[][] numbers;
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    numbers = new int[5][5];
    count=0;
    for(int i=0;i<5;i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < input.length; j++) {
        numbers[i][j] = Integer.parseInt(input[j]);
      }
    }
    int callCount=0;
    for(int i=0;i<5;i++) {
      String[] call = br.readLine().split(" ");
      for (int j = 0; j < 5; j++) {
        callCount++;
        int num = Integer.parseInt(call[j]);
        for (int x = 0; x < 5; x++) {
          for (int y = 0; y < 5; y++) {
            if (numbers[x][y] == num) {
              numbers[x][y] = 0;
            }
          }
        }
        row();
        col();
        left();
        right();

        if (count >= 3) {
          System.out.println(callCount);
          return;
        }
        count=0;
      }
    }
  }
  public static void row(){
    for(int i=0;i<5;i++){
      int zero=0;
      for(int j=0;j<5;j++){
        if (numbers[j][i] == 0) {
          zero++;
        }
        if(zero ==5){
          count++;
        }
      }
    }
  }
  public static void col(){
    for(int i=0;i<5;i++) {
      int zero = 0;
      for (int j = 0; j < 5; j++) {
        if (numbers[i][j] == 0) {
          zero++;
        }
        if (zero == 5) {
          count++;
        }
      }
    }
  }
  public static void left(){
    int zero=0;
    for(int i=0;i<5;i++){
      if (numbers[i][i] == 0) {
        zero++;
      }
    }
    if(zero ==5){
      count++;
    }
  }
  public static void right(){
    int zero=0;
    for(int i=0;i<5;i++){
      if (numbers[i][4-i] == 0) {
        zero++;
      }
    }
    if(zero ==5){
      count++;
    }
  }
}
