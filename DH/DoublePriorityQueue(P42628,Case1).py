# 작성일 : 2021.10.07
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>힙(Heap)>이중우선순위큐]
# 메모 : 최소정렬힙, 최대정렬힙을 이용한 풀이.
#       최대정렬 상에서 pop하는 로직은 메소드 heappop_max로 구현.
#       근데 힙을 통한 방법이 아니었다면, 아마 이진탐색트리 정렬을 통해 풀려고 애쓰지 않았을까용?



import heapq

def solution(operations):

    heap = []

    for ops in operations :
        if ops[0] == "I" :
            heapq.heappush(heap, int(ops[2:]))
        elif len(heap) != 0 :
            if ops[0:3] == "D 1" :
                heappop_max(heap)
            elif ops[0:4] == "D -1" :
                heapq.heappop(heap)

    if len(heap) == 0 :
        value = [0, 0]
    elif len(heap) == 1 :
        value = [heap[0], heap[0]]
    else :
        value = [heappop_max(heap), heapq.heappop(heap)]

    return value

def heappop_max(minheap) :

    maxheap = []
    
    while len(minheap) != 0 :
        heapq.heappush(maxheap, int(heapq.heappop(minheap)) * (-1))
        
    value = (-1) * heapq.heappop(maxheap)
    
    while len(maxheap) != 0 :
        heapq.heappush(minheap, int(heapq.heappop(maxheap)) * (-1))

    return value 
