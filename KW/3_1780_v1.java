/*
v1 : Naive approach
중복해서 체크하는 영역이 있다.
개선 방법은?
memory : 330,180 KB
time : 1,364 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

    private int N;
    private int[][] space;

    public static Solution getSolution() {
        if(solution == null) solution = new Solution();
        return solution;
    }

    public void solve() throws IOException {
        getInputs();
        Map<Integer, Integer> result = new HashMap<>();
        int[] keySet = new int[]{-1, 0, 1};
        for(int k : keySet){
            result.put(k, 0);
        }
        getPaperColor(0, 0, N, result);
        for(int k : keySet){
            sb.append(result.get(k)).append("\n");
        }
        printString();
    }

    private void getPaperColor(int fromI, int fromJ, int size, Map<Integer, Integer> result) {
        boolean isOne = true;
        for (int i = fromI; i < fromI + size; i++) {
            for (int j = fromJ; j < fromJ + size; j++) {
                if(space[i][j]  != space[fromI][fromJ]){
                    isOne = false;
                    break;
                }
            }
            if(!isOne) break;
        }
        if(isOne){
            int curr = result.get(space[fromI][fromJ]);
            result.put(space[fromI][fromJ], curr+1);
        }else{
            int nextSize = size/3;
            for (int i = 0; i < 3; i++) {
                getPaperColor(fromI + 0 * nextSize, fromJ, nextSize, result);
                getPaperColor(fromI + 1 * nextSize, fromJ, nextSize, result);
                getPaperColor(fromI + 2 * nextSize, fromJ, nextSize, result);
                fromJ += nextSize;
            }
        }

    }

    private void printString() throws IOException {
        br.close();
        System.out.println(sb.toString());
    }

    public void getInputs() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        space = new int[N][N];

        for (int i = 0; i < N; i++) {
            space[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
