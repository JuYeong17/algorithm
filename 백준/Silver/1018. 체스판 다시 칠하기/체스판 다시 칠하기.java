import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    String[][] board = new String[N][M];
    for(int i=0;i<N;i++){
      String[] input2 = br.readLine().split("");
      for(int j=0;j<M;j++){
        board[i][j] = input2[j];
      }
    }
    int minCount = Integer.MAX_VALUE;

    for(int i=0;i< N-7 ;i++){
      for(int j=0;j<M-7;j++) {
        int countW = 0;
        int countB = 0;

        for (int x = 0; x < 8; x++) {
          for (int y = 0; y < 8; y++) {
            String expectedW = ((x + y) % 2 == 0) ? "W" : "B";
            String expectedB = ((x + y) % 2 == 0) ? "B" : "W";

            if (!board[i + x][j + y].equals(expectedW)) countW++;
            if (!board[i + x][j + y].equals(expectedB)) countB++;
          }
        }

        int repaint = Math.min(countW, countB);
        if (repaint < minCount) {
          minCount = repaint;
        }
      }
    }
    System.out.println(minCount);
  }
}
