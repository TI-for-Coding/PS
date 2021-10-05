import heapq                # Heap 자료구조 호출

def solution(scoville, K):
    
    heap_scoville = []      # 배열을 새로 선언하여 Heap 자료형으로 사용할 예정
    
    for s in scoville : 
        
        heapq.heappush(heap_scoville, s)    # Heap 자료구조에 소스 입력
    
    answer = 0
    
    while True :
        
        f1 = heapq.heappop(heap_scoville)   # Heap 자료구조로부터 스코빌 지수 최소값 pop
        
        if f1 >= K :                        # 최소값이 주어진 K보다 높으면, break
            break
        elif f1 < K :
            if len(heap_scoville) >= 1 :            # 섞을 수 있는 소스가 남아있으면, 조합하여 Heap 자료구조에 push
                f2 = heapq.heappop(heap_scoville)
                heapq.heappush(heap_scoville, (f1 + (f2 * 2)))
            else :                                  # 섞을 수 있는 소스가 없고, K보다 작으면 -1 출력
                answer = -1
                break
                
        answer = answer + 1
    
    return answer
