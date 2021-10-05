import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> heapScoville = new PriorityQueue<Integer>();
        for (int i = 0; i < scoville.length; i++) {
            heapScoville.add(scoville[i]);
        }
        
        int answer = 0;
        int f1 = 0;
        int f2 = 0;
        
        while (true) {
            
            f1 = heapScoville.poll();
            
            if (f1 >= K) {    
                break;
            } else {
                if (heapScoville.size() >= 1) {
                    f2 = heapScoville.poll();
                    heapScoville.add(f1 + (f2 * 2));
                } else {
                    answer = -1;
                    break;
                }
            }
            
            answer = answer + 1;
            
        }
      
        return answer;
      
    }
}
