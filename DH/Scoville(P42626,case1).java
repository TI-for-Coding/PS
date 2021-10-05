/* 작성일 : 2021.10.05
** 언어 : Java
** 출처 : 프로그래머스 [코딩테스트 연습>힙(Heap)>더 맵게]
** 메모 : 자바의 Queue 자료구조 패키지를 활용하여 문제 풀이
*/

import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> heapScoville = new PriorityQueue<Integer>();  // JAVA 환경에서 Integer 기반 Heap 자료구조 패키지 호출
        
        for (int i = 0; i < scoville.length; i++) {     // Heap 자료구조에 데이터 입력
            heapScoville.add(scoville[i]);
        }
        
        int answer = 0;     // answer는 정답을 저장하는 변수
        int f1 = 0;         // f1, f2는 매운 소스를 Heap으로부터 Pull하여 저장하는 변수
        int f2 = 0;         
        
        while (true) {
            
            f1 = heapScoville.poll();
            
            if (f1 >= K) {      // Heap의 최소값이 주어진 K보다 높으면, break
                break;
            } else {
                if (heapScoville.size() >= 1) {         // Heap의 최소값이 주어진 K보다 작은데, 섞을 수 있는 소스가 있으므로 새로 조합
                    f2 = heapScoville.poll();
                    heapScoville.add(f1 + (f2 * 2));
                } else {                                // Heap의 최소값이 주어진 K보다 작은데, 더이상 섞을 수 없는 소스가 없으므로 종료
                    answer = -1;
                    break;
                }
            }
            
            answer = answer + 1;    // 작업을 카운트함
            
        }
      
        return answer;
      
    }
}
