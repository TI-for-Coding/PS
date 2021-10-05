import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Arrays.stream(scoville).boxed().collect(Collectors.toList()));

        while(queue.size() > 1 && queue.peek() < K){
            int first = queue.poll();
            int second = queue.poll();

            queue.add(first + second * 2);
            answer++;
        }

        return queue.peek() >= K ? answer : -1;
    }
}