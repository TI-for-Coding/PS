/* 작성일 : 2021.10.05
** 언어 : Java
** 출처 : 프로그래머스 [코딩테스트 연습>스택/큐>프린터]
** 메모 : 자바 Queue 패키지를 활용한 풀이 및 Queue 구조의 최대값을 호출하는 메소드 활용
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    public static int solution(int[] priorities, int location) {
        
        int answer = 0;
        int val = 0;
        int maxVal = 0;
        int index = 0;
        
        Queue<Integer> queuePriorities = new LinkedList<Integer>();
        Queue<Integer> queueIndexes = new LinkedList<Integer>();
        
        index = 0;
        while (index < priorities.length) {
            queuePriorities.add(priorities[index]);
            queueIndexes.add(index);
            index++;
        }
        
        index = 0;
        while (true) {
            
            maxVal = max(queuePriorities);
            val = queuePriorities.poll();
            index = queueIndexes.poll();
            
            if (maxVal == val) {
                answer++;
                if (index == location) {
                    break;
                } else {
                    continue;
                }
            } else {
                queuePriorities.offer(val);
                queueIndexes.offer(index);
            }
            
        }
        return answer;
    }
    
    public static int max (Queue<Integer> queue) {
        int max = -1;
        for (int i = 0; i <= queue.size() - 1; i++) {
            if (max <= Integer.parseInt(queue.toArray()[i].toString())) {
                max = Integer.parseInt(queue.toArray()[i].toString());
            }
        }
        return max;
    }
    
}
