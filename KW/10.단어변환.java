import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {

    private List<Integer> costs = new ArrayList<>();

    public int solution(String begin, String target, String[] words) {
        dfs(0, begin, target, new boolean[words.length], words);
        return costs.stream().min(Integer::compareTo).orElse(0);
    }

    private void dfs(int currCost, String curr, String target, boolean[] visited, String[] words) {

        if (curr.equals(target)) {
            costs.add(currCost);
            return;
        }

        for(int i = 0; i < words.length ; i++) {
            if(!visited[i] && countDiff(curr, words[i]) == 1) {
                visited[i] = true;
                dfs(currCost+1, words[i], target, visited, words);
                visited[i] = false;
            }
        }
    }

    private int countDiff(String str1, String str2) {
        return (int) IntStream.range(0, str1.length())
                .filter(index -> str1.charAt(index) != str2.charAt(index))
                .count();
    }
}
