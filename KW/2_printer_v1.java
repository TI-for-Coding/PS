import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<MyJob> queue = IntStream.range(0, priorities.length)
                .mapToObj(num -> new MyJob(num, priorities[num]))
                .collect(Collectors.toCollection(LinkedList::new));

        while(true){
            MyJob maxPriority = queue.stream().max(MyJob::compareTo).get();
            while(queue.peek().getPriority() < maxPriority.getPriority()){
                queue.add(queue.poll());
            }

            MyJob curr = queue.poll();
            answer++;
            if(curr.getNum() == location) return answer;
        }
    }
}

class MyJob implements Comparable {
    private int num, priority;
    public MyJob(int num, int priority){
        this.num = num;
        this.priority = priority;
    }

    public int getNum() {
        return num;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.getPriority(), ((MyJob)o).getPriority());
    }
}