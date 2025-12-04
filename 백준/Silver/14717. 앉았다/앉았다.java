import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static int score(int a, int b){
    if ( a == b) return a *10;
    return (a+b) % 10;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer((br.readLine()));
    int x= Integer.parseInt(st.nextToken());
    int y= Integer.parseInt(st.nextToken());

    List<Integer> deck = new ArrayList<>();
    for( int i=1;i<=10;i++){
      deck.add(i);
      deck.add(i);
    }
    deck.remove((Integer) x);
    deck.remove((Integer) y);
    int Myscore = score(x,y);
    int win=0;int total=0;

    for(int i=0;i< deck.size();i++){
      for(int j=i+1;j< deck.size();j++){
        int x2 = deck.get(i);
        int y2 = deck.get(j);
        int YourScore =score(x2,y2);
        if(Myscore > YourScore) win++;
        total++;
      }
    }
    System.out.printf("%.3f\n",(double) win/ total);
  }
}