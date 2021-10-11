import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[][]> waitingQue = new LinkedList<int[][]>();
        // 작업의 처음 위치와 우선순위를 기억하기 위해 2차원 배열 생성
        int[][] work = new int[priorities.length][2];

        for (int i = 0; i < priorities.length; i++) {
            work[i][0] = i; // 작업 location
            work[i][1] = priorities[i]; // 작업 우선순위
            waitingQue.add(work);
        }

        while (!waitingQue.isEmpty()) {
            int[][] currentWork = waitingQue.poll();
            boolean checkPriority = false;
            int[][] waitingWork = {};

            // 대기목록에 우선순위 더 큰 작업이 있는지 확인
            for (int i = 0; i < waitingQue.size(); i++) {
                waitingWork = waitingQue.peek();
                if (currentWork[0][1] < waitingWork[0][1]) {
                    checkPriority = true;
                }
            }

            if (checkPriority) {
                // 우선순위가 더 큰 작업이 있을 경우 현재작업 대기목록에 추가
                waitingQue.add(currentWork);
            } else {
                answer++;
                if(currentWork[0][0] == waitingWork[0][0]) {
                    return answer;
                }
            }
        }

        return answer;
    }
}
