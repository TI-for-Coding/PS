package PriorityQue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {
    public static void main(String[] args) throws Exception {
        System.out.println("Disk Controller!");
        int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };

        // System.out.println(queue);
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {

        int answer = 0; // 작업 평균 시간
        // 1. 요청시간 빠른 것 먼저 처리
        // 2. 같은 요청 시간 경우 작업 시간 빠른 것 먼저 처리

        int numOfJobs = jobs.length; // 전체 작업 갯수
        int jobTime = 0;
        int totalTime = 0;
        int cnt = 0;
        int idx = 0;

        System.out.println("numOfJobs: " + numOfJobs);

        // 2차원 배열 오름차순 정리
        Arrays.sort(jobs, (a1, a2) -> {
            if (a1[0] == a2[0]) {
                return Integer.compare(a1[1], a2[1]);
            } else {
                return Integer.compare(a1[0], a2[0]);
            }
        });

        // 우선순위 큐
        // 아래 코드 오류 발생함
        // PriorityQueue<int[]> priorityJobQueue = new PriorityQueue<>();
        /*
         * class [I cannot be cast to class java.lang.Comparable ([I and
         * java.lang.Comparable are in module java.base of loader 'bootstrap')
         */
        PriorityQueue<int[]> priorityJobQueue = new PriorityQueue<>((q1, q2) -> q1[1] - q2[1]);

        // 전체 작업 처리
        // for (int i = 0; i < jobs.length; i++) {
        while (cnt < numOfJobs) {
            // System.out.println("JobIdx: " + i);

            // for (int j = 0; j <= requestTime; j++) {
            while (idx < numOfJobs && jobs[idx][0] <= jobTime) {
                // 작업 요청 시간이 전체 진행시간 보다 작다면 우선순위 큐에 추가
                // idx++;
                priorityJobQueue.add(jobs[idx++]);
                // System.out.println("jobs[" + i + "]: " + jobs[i][0] + "" + jobs[i][1]);
            }

            // 우선순위 큐에서 작업량이 작은 작업부터처리
            if (!priorityJobQueue.isEmpty()) {
                // for (int q = 0; q < priorityJobQueue.size(); q++) {
                // while (priorityJobQueue.isEmpty()) {
                // 작업 건당 소요 시간 -> 이전 작업 시간 + 작업 처리 시간 - 작업 요청 시간
                int[] job = priorityJobQueue.poll();

                // 3 = (0 + 3) - 0
                // 7 = (3 + 6) - 2
                // 16 = (9 + 9) - 1
                totalTime += jobTime + job[1] - job[0];
                jobTime += job[1];
                // System.out.println("jobTime: " + jobTime);
                // System.out.println("totalTime: " + totalTime);
                cnt++;
                // }
            } else {
                jobTime = jobs[idx][0];
            }
        }
        // System.out.println("totalTime: " + totalTime);
        // System.out.println("avgTime: " + totalTime / numOfJobs);
        answer = totalTime / numOfJobs;

        return answer;
    }
}
