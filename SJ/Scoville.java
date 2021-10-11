import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int firstFood = 0;
        int secondFood = 0;
        int mixedFood =0;
        // 우선순위 큐 사용하여 리스트 정렬
        // 당초 그냥 큐로 사용하여 풀었으나 뒤에 다시 정렬해야하는 상황 발생
        // 시간 초과 우려하여 우선순위 큐로 바꿈
        PriorityQueue<Integer> foodQue = new PriorityQueue<Integer>();

        // 큐에 food 리스트 추가
        // int[] -> int 바로 변환하며 큐에 추가할 수 있는 방법이 있는지 궁금합니다...
        for(int i=0; i<scoville.length; i++){
            foodQue.add(scoville[i]);
        }
        
        while (!foodQue.isEmpty()) {
    
            // 큐의 처음 값이 K 보다 높은 경우 답 출력
            if(foodQue.peek()>=K) {
                return answer;
            }

            // 큐 사이즈가 1이고, K 보다 낮은 경우 답 출력
            if(foodQue.size()==1 && foodQue.peek()<K) {
                answer = -1;
                return answer;
            }
            
            // 나머지 경우 새로운 음식 만들기 진행
            firstFood = foodQue.poll();
            secondFood = foodQue.poll();
                
            mixedFood = firstFood + (secondFood*2);
            
            foodQue.offer(mixedFood);
            answer++;
        }
        
        return answer;
    }
}
