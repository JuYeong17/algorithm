import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<String, String> history = new HashMap<>();
    int N = Integer.parseInt(br.readLine());
    List<String> result = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String key = st.nextToken();
      String value = st.nextToken();
      history.put(key, value);
    }
    history.forEach((key, value) -> {
      if ("enter".equals(value)) {
        result.add(key);
      }
    });

    Collections.sort(result,Collections.reverseOrder());
    
    result.forEach(System.out::println);
  }
}
