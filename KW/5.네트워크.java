/*
BFS와 DFS 방법을 모두 적어보려다보니, 중복되는 코드들이 생겨서, template-callback 을 적용하였습니다.
중복되는 코드는 template으로,
변경되는 코드(dfs, bfs)는 funtional interface로,
하여 작성하였습니다.

혹시나, 보시는 분께 제가 도움이 될 수 있을까 하여..
중복되는 코드들이 있는 상태를 아래에 남겨두었습니다.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {

//        TraverseAlgorithm algo = bfs();       //BFS
        TraverseAlgorithm algo = dfs();         //DFS
        return traverseTemplate(n, computers, algo);
    }

    private int traverseTemplate(int n, int[][] computers, TraverseAlgorithm algorithm) {
        boolean[] visited = new boolean[n];
        
        int count = 0;

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                algorithm.doTraverse(i, computers, visited);
                count++;
            }
        }

        return count;
    }

    private TraverseAlgorithm dfs() {

        return new TraverseAlgorithm() {
            @Override
            public void doTraverse(int node, int[][] link, boolean[] visited) {
                visited[node] = true;
                for (int computer = 0; computer < visited.length; computer++) {
                    if(!visited[computer] && link[node][computer] == 1) doTraverse(computer, link, visited);
                }
            }
        };
    }

    private TraverseAlgorithm bfs() {
        return new TraverseAlgorithm() {
            @Override
            public void doTraverse(int node, int[][] link, boolean[] visited) {
                Queue<Integer> q = new LinkedList<>(List.of(node));
                visited[node] = true;
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for (int computer = 0; computer < visited.length; computer++) {
                        if(!visited[computer] && link[curr][computer] == 1){
                            visited[computer] = true;
                            q.add(computer);
                        }
                    }
                }
            }
        };
    }
}

@FunctionalInterface
interface TraverseAlgorithm{
    void doTraverse(int node, int[][] link, boolean[] visited);
}


// byDFS, byBFS 를 보시면,
// 코드가 같습니다. (실제 순회하는 부분을 제외하고)

//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//class Solution {
//
//    public int solution(int n, int[][] computers) {
//
//        return byDFS(n, computers);
////        return byDFS(n, computers);
//    }
//
//
//    private int byBFS(int n, int[][] computers) {
//
//        boolean[] visited = new boolean[n];
//        Arrays.fill(visited, false);
//
//        int count = 0;
//
//        for (int i = 0; i < n; i++) {
//            if(!visited[i]){
//                bfs(i, computers, visited);         //여기만 변경됨.
//                count++;
//            }
//        }
//
//        return count;
//    }
//
//
//    private int byDFS(int n, int[][] computers) {
//        boolean[] visited = new boolean[n];
//        Arrays.fill(visited, false);
//        int count = 0;
//
//        for (int i = 0; i < n; i++) {
//            if(!visited[i]){
//                dfs(i, computers, visited);         //여기만 변경됨.
//                count++;
//            }
//        }
//
//        return count;
//    }
//
//    private void dfs(int node, int[][] link, boolean[] visited) {
//        visited[node] = true;
//        for (int computer = 0; computer < visited.length; computer++) {
//            if(!visited[computer] && link[node][computer] == 1){
//                dfs(computer, link, visited);
//            }
//        }
//    }
//
//    private void bfs(int node, int[][] link, boolean[] visited){
//        Queue<Integer> q = new LinkedList<>(List.of(node));
//        visited[node] = true;
//        while(!q.isEmpty()){
//            int curr = q.poll();
//            for (int computer = 0; computer < visited.length; computer++) {
//                if(!visited[computer] && link[curr][computer] == 1){
//                    visited[computer] = true;
//                    q.add(computer);
//                }
//            }
//        }
//    }
//}