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

    public static Solution getSolution() {
        if(solution == null) solution = new Solution();
        return solution;
    }

    public void solve() throws IOException {
        setData();
    }

    private void setData() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] prev, curr, dp;

        prev = new int[]{Integer.parseInt(br.readLine())};
        dp = Arrays.copyOf(prev, prev.length);
        for (int i = 2; i < N+1; i++) {
            curr =  Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();

            dp = new int[i];
            dp[0] = curr[0] + prev[0];
            dp[i-1] = curr[i-1] + prev[i-2];
            for (int t = 1; t < i-1; t++) {
                dp[t] = Math.max(prev[t-1], prev[t]) + curr[t];
            }
            prev = dp;
        }

        System.out.println(Arrays.stream(dp).max().orElse(-1));
        br.close();
    }
}