import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int idx = 0;
        int currTime = 0;

        SJFScheduler scheduler = new SJFScheduler();

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        while(idx < jobs.length || scheduler.hasJob()){
            // 1st step
            // insert jobs into scheduler job list
            while(idx < jobs.length && jobs[idx][0] <= currTime){
                scheduler.insertJob(jobs[idx++]);
            }

            if(!scheduler.hasJob()) currTime = Math.max(currTime, jobs[idx][0]);

            // 2nd step
            // process a job
            if(scheduler.hasJob()){
                MyJob processed = scheduler.processJob();
                currTime += processed.getExecutionTime();
                answer += currTime - processed.getInTime();
            }
        }

        return answer / jobs.length;
    }
}

class SJFScheduler{
    private PriorityQueue<MyJob> readyQueue;
    public SJFScheduler(){
        readyQueue = new PriorityQueue<>();
    }

    public boolean hasJob() {
        return !readyQueue.isEmpty();
    }

    public void insertJob(int[] job) {
        readyQueue.add(new MyJob(job[0], job[1]));
    }

    public MyJob processJob() {
        return readyQueue.poll();
    }
}

class MyJob implements Comparable{
    private int inTime, executionTime;

    public MyJob(){

    }

    public MyJob(int inTime, int executionTime){
        this.inTime = inTime;
        this.executionTime = executionTime;
    }

    public int getInTime() {
        return inTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.executionTime, ((MyJob)o).executionTime);
    }
}
