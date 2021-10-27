import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Solution solution = Solution.getInstance();
        solution.solve();
    }
}

class Solution{

    private static Solution solution;

    private BufferedReader br;
    private StringBuilder sb;
    private StringTokenizer st;

    private int N, M, V;
    private int[][] link;

    public static Solution getInstance() {
        if(solution==null) solution = new Solution();
        return solution;
    }

    public void solve() throws IOException {

        getInputData();
        boolean[] visited = new boolean[N+1];

        dfs(V, visited);

        sb.append("\n");
        Arrays.fill(visited, false);

        bfs(V, visited);
        printAnswer();

    }

    private void bfs(int node, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            sb.append(curr).append(" ");
            for (int i = 1; i < N+1; i++) {
                if(!visited[i] && link[curr][i] == 1){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    private void dfs(int node, boolean[] visited) {
        visited[node] = true;
        sb.append(node).append(" ");
        for (int i = 1; i < N+1; i++) {
            if(!visited[i] && link[node][i] == 1)dfs(i, visited);
        }
    }

    private void printAnswer() throws IOException {
        System.out.println(sb.toString());
        br.close();
    }

    private void getInputData() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        link = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            link[a][b] = 1;
            link[b][a] = 1;

        }
    }
}