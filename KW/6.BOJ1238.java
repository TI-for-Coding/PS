// 쓰레드를 활용한 내용은 주석처리 하였습니다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main{
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Solution solution = Solution.getSolution();
        solution.solve();
    }
}

class Solution{
    private static final int INF = Integer.MAX_VALUE;
    private BufferedReader br;
    private StringBuilder sb;
    private StringTokenizer st;

    private int N, M, X;

    private List<List<int[]>> edges, reversed;

    private static Solution solution;

    public static Solution getSolution() {
        if(solution == null) solution = new Solution();
        return solution;
    }

    public void solve() throws IOException {
        setData();

        int[] toDestination = findCostsBy(edges);
        int[] toHome = findCostsBy(reversed);
        printAnswer(toDestination, toHome);


//        아래는 두개 작업을 쓰레드를 통해 처리하고자 하였으나,
//        백준 실행환경에서는 쓰레드를 지원하지 않는다고 하여 주석처리 하였습니다

//        FutureTask<int[]> toDestination = new FutureTask<>(
//                () -> findCostsBy(edges)
//        );
//
//        FutureTask<int[]> toHome = new FutureTask<>(
//                () -> findCostsBy(reversed)
//        );
//
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.execute(toDestination);
//        executorService.execute(toHome);
//
//        printAnswer(toDestination.get(), toHome.get());

    }

    private int[] findCostsBy(List<List<int[]>> link) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[X] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(dist[curr.key] < curr.dist) continue;
            dist[curr.key] = curr.dist;
            for(int[] edge : link.get(curr.key)){
                int relaxed = curr.dist + edge[1];
                if(dist[edge[0]] > relaxed){
                    dist[edge[0]] = relaxed;
                    pq.add(new Node(edge[0], relaxed));
                }
            }
        }
        return dist;
    }

    private void printAnswer(int[] toDestination, int[] toHome) {
        int maxValue = IntStream.range(1, N+1)
                .map(node -> toDestination[node] + toHome[node])
                .max().getAsInt();
        sb.append(maxValue);
        System.out.println(sb);
    }

    private void setData() throws IOException {
        sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        X = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        reversed = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            edges.add(new ArrayList<>());
            reversed.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.get(from).add(new int[]{to, weight});
            reversed.get(to).add(new int[]{from, weight});

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