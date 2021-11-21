import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        Solution solution = Solution.getSolution();
        solution.solve();
    }
}

class Solution{
    private static Solution solution;

    private BufferedReader br;
    private StringTokenizer st;

    private int N;
    private int[][] costs;

    private final int RED = 0;
    private final int GREEN = 1;
    private final int BLUE = 2;

    public static Solution getSolution() {
        if(solution == null) solution = new Solution();
        return solution;
    }

    public void solve() throws IOException {
        setData();
        int[][] dp = getMinDP();
        printAnswer(dp);
    }

    private int[][] getMinDP() {
        int[][] dp = new int[N][3];
        dp[0] = Arrays.copyOfRange(costs[0], 0, 3);

        for (int i = 1; i < N; i++) {
            for (int color = 0 ; color < 3 ; color++) {
                switch (color){
                    case RED :
                        dp[i][RED] = costs[i][RED]
                                + Math.min(dp[i-1][GREEN], dp[i-1][BLUE]);
                        break;
                    case GREEN :
                        dp[i][GREEN] = costs[i][GREEN]
                                + Math.min(dp[i-1][RED], dp[i-1][BLUE]);
                        break;
                    case BLUE :
                        dp[i][BLUE] = costs[i][BLUE]
                                + Math.min(dp[i-1][RED], dp[i-1][GREEN]);
                        break;
                }
            }
        }

        return dp;
    }

    private void printAnswer(int[][] dp) {
        int minCost = Arrays.stream(dp[N-1]).min().orElse(-1);
        System.out.println(minCost);
    }

    private void setData() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        costs = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i][RED] = Integer.parseInt(st.nextToken());
            costs[i][GREEN] = Integer.parseInt(st.nextToken());
            costs[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

}