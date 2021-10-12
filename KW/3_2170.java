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
    private List<Point> points;

    public static Solution getSolution() {
        if(solution == null) solution = new Solution();
        return solution;
    }

    public void solve() throws IOException {
        setInput();
        int result = findAnswer();
        sb.append(result);
        printString();
    }

    private int findAnswer() {
        int result = 0;
        Collections.sort(points);

        int start = (int) -1e9;
        int end = (int) -1e9;
        for (Point p : points) {
            if(p.from <= end){
                end = Math.max(end, p.to);
            }else{
                result += end - start;
                end = p.to;
                start = p.from;
            }
        }
        result += end - start;

//  more readable
//        int curIdx = 0;
//        while(curIdx < N){
//            int start = points.get(curIdx).from;
//            int end = points.get(curIdx).to;
//            while(++curIdx < N && points.get(curIdx).from <= end){
//                end = Math.max(end, points.get(curIdx).to);
//            }
//            result += end - start;
//        }

        return result;
    }

    private void printString() throws IOException {
        br.close();
        System.out.println(sb.toString());
    }

    private void setInput() throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

    }
}

class Point implements Comparable<Point>{
    public final int from, to;
    public Point(int from, int to){
        this.from = from;
        this.to = to;
    }

    @Override
    public int compareTo(Point o) {
        return Integer.compare(this.from, o.from);
    }

}