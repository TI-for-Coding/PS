import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = Solution.getSolution();
        solution.solve();
    }

}

class Solution{
    private static Solution solution;

    private BufferedReader br;
    private StringTokenizer st;
    private StringBuilder sb;

    private int N, M;
    private List<int[]> backward;


    public static Solution getSolution() {
        if(solution == null) solution = new Solution();
        return solution;
    }

    public void solve() throws IOException {
        getInputs();
        findAnswer();
        printString();
    }

    private void findAnswer() {
        long result = M;

        backward.sort(Comparator.comparingInt(item -> -item[0]));
        int curIdx = 0;
        while(curIdx < backward.size()){
            int from = backward.get(curIdx)[0];
            int to = backward.get(curIdx)[1];
            while(++curIdx < backward.size() && backward.get(curIdx)[0] >= to){
                to = Math.min(to, backward.get(curIdx)[1]);
            }
            result += (from - to) * 2L;
        }
        sb.append(result);
    }


    private void printString() throws IOException {
        br.close();
        System.out.println(sb.toString());
    }

    public void getInputs() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backward = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(from > to) backward.add(new int[]{from, to});
        }
    }
}
