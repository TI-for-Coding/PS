import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Solution solution = Solution.getSolution();
        solution.solve();
    }
}

class Solution{
    private BufferedReader br;
    private StringBuilder sb;
    private StringTokenizer st;

    private int V, E, K;

    private List<List<int[]>> edges;

    private static Solution solution;

    public static Solution getSolution() {
        if(solution == null) solution = new Solution();
        return solution;
    }

    public void solve() throws IOException {
        setData();
        int[] costs = new int[V+1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        findShortestPathByNode(costs);
        printAnswer(costs);
    }

    private void findShortestPathByNode(int[] costs) {
        costs[K] = 0;
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, costs[K]));

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(visited[curr.key]) continue;
            visited[curr.key] = true;
            for(int[] adj : edges.get(curr.key)){
                if(!visited[adj[0]]){
                    int curCost = costs[curr.key] + adj[1];
                    if(costs[adj[0]] > curCost){
                        costs[adj[0]] = curCost;
                        queue.add(new Node(adj[0], curCost));
                    }
                }
            }
        }
    }

    private void printAnswer(int[] costs) {
        for (int i = 1; i < costs.length; i++) {
            if(costs[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(costs[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private void setData() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();

        for (int i = 0; i < V+1; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.get(from).add(new int[]{to, weight});
        }

        br.close();
    }
}

class Node implements Comparable<Node>{
    public int key, dist;
    public Node(int k, int d){
        key = k;
        dist = d;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.dist, o.dist);
    }
}