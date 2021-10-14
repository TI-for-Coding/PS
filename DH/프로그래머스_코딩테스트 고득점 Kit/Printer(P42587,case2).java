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
        while (index < priorities.length) {             // 큐에 필요한 작업내역들을 저장
            queuePriorities.add(priorities[index]);
            queueIndexes.add(index);
            index++;
        }
        
        index = 0;
        while (true) {
            
            maxVal = max(queuePriorities);      // 작업수행 시마다, 큐 내의 우선순위 최대값 저장
            val = queuePriorities.poll();       // 프린트 대상을 pop
            index = queueIndexes.poll();        // 프린트 대상의 위치 (Index) pop
            
            if (maxVal == val) {                // 프린트 대상의 우선순위가 최대값이라면,
                answer++;                       // 프린트 (time ++)
                if (index == location) {        // 찾고자 하는 위치의 작업이었다면 종료
                    break;
                } else {                        // 아니면 지속 수행
                    continue;
                }
            } else {
                queuePriorities.offer(val);     // 프린트 대상의 우선순위가 최대값이 아니라면, 후순으로 push
                queueIndexes.offer(index);
            }
            
        }
        return answer;
    }
    
    public static int max (Queue<Integer> queue) {      // 정수형 queue의 최대값을 찾는 매소드 
        int max = -1;
        for (int i = 0; i <= queue.size() - 1; i++) {
            if (max <= Integer.parseInt(queue.toArray()[i].toString())) {
                max = Integer.parseInt(queue.toArray()[i].toString());
            }
        }
        return max;
    }
    
}
