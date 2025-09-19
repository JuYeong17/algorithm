import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board;
    static boolean[] selected;
    static int MIN_RESULT = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);
        System.out.println(MIN_RESULT);
    }

    static void comb(int depth, int start) {
        if (depth == N / 2) {
            MIN_RESULT = Math.min(MIN_RESULT, calcDiff());
            return;
        }

        for (int i = start; i < N; i++) {
            selected[i] = true;
            comb(depth + 1, i + 1);
            selected[i] = false;
        }
    }

    static int calcDiff() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (selected[i] && selected[j]) {
                    startTeam += board[i][j] + board[j][i];
                } else if (!selected[i] && !selected[j]) {
                    linkTeam += board[i][j] + board[j][i];
                }
            }
        }

        return Math.abs(startTeam - linkTeam);
    }
}