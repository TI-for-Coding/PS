import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        Solution solution = Solution.getSolution();
        solution.solve();
    }
}

class Solution{
    private static Solution solution;

    private BufferedReader br;

    private int N;
    private final int divide = 1000000000;

    public static Solution getSolution() {
        if(solution == null) solution = new Solution();
        return solution;
    }

    public void solve() throws IOException {
        setData();
        System.out.println(findAnswer());
    }

    private int findAnswer() {
        int[][] dp = new int[2][10];
        dp[0] = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int curr = 0;
        int prev = 1;
        for (int i = 1; i < N; i++) {
            curr = i%2;
            prev = (curr + 1) % 2;
            dp[curr][0] = dp[prev][1];
            dp[curr][9] = dp[prev][8];

            for (int j = 1; j <= 8; j++) {
                dp[curr][j] = (dp[prev][j-1] + dp[prev][j+1]) % divide;
            }
        }
        long answer = 0;
        for(int value : dp[curr]){
            answer += value;
        }
        return (int) (answer % divide);
    }


    private void setData() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
    }
}