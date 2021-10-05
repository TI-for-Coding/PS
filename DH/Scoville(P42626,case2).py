import heapq

def solution(scoville, K):
    
    heap_scoville = []
    
    for s in scoville : 
        
        heapq.heappush(heap_scoville, s)
    
    answer = 0
    
    while True :
        
        f1 = heapq.heappop(heap_scoville)
        
        if f1 >= K :
            break
        elif f1 < K :
            if len(heap_scoville) >= 1 :
                f2 = heapq.heappop(heap_scoville)
                heapq.heappush(heap_scoville, (f1 + (f2 * 2)))
            else :
                answer = -1
                break
                
        answer = answer + 1
    
    return answer
