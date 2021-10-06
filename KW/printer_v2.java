import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue =
                IntStream.range(0, priorities.length)
                        .boxed()
                        .collect(Collectors.toCollection(LinkedList::new));

        int[] sortedByPriority = Arrays.stream(priorities).sorted().toArray();
        int currMax = priorities.length - 1;
        while(true){
            int curr = queue.poll();
            if(priorities[curr] == sortedByPriority[currMax - answer]){
                answer++;
                if(curr == location) break;
            }else{
                queue.add(curr);
            }

        }
        return answer;
    }
}