# 작성일 : 2021.10.07
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>힙(Heap)>이중우선순위큐]
# 메모 : 최소정렬힙, 최대정렬힙을 이용한 풀이.
#       최대정렬 상에서 pop하는 로직은 메소드 heappop_max로 구현.
#       근데 힙을 통한 방법이 아니었다면, 아마 이진탐색트리 정렬을 통해 풀려고 애쓰지 않았을까용?

import heapq

def solution(operations):

    heap = []

    for ops in operations :                     # = 입력값을 순차적으로 연산
        if ops[0] == "I" :                      # I는 힙 구조에 Push하는 연산
            heapq.heappush(heap, int(ops[2:]))  
        elif len(heap) != 0 :                   # D는 힙 구조에 데이터가 존재해야 작동함 (여기서 당황함)
            if ops[0:3] == "D 1" :              # "D 1"은 힙 정렬상의 최대값을 Pop
                heappop_max(heap)
            elif ops[0:4] == "D -1" :           # "D -1"은 힙 정렬상의 최소값을 Pop
                heapq.heappop(heap)

    if len(heap) == 0 :                
        value = [0, 0]
    elif len(heap) == 1 :               
        value = [heap[0], heap[0]]                          # len(heap) <= 1 의 경우는, 결과 상의 예외처리
    else :
        value = [heappop_max(heap), heapq.heappop(heap)]    # 최대값과 최소값이 명확히 존재하는 경우, 최대정렬힙과 최소정렬힙을 사용한 결과 출력

    return value

def heappop_max(minheap) :

    maxheap = []
    
    while len(minheap) != 0 :
        heapq.heappush(maxheap, int(heapq.heappop(minheap)) * (-1))     # 최대정렬힙으로 전환 (음수 전환)
        
    value = (-1) * heapq.heappop(maxheap)                               # 최대정렬힙 상에서 Pop
    
    while len(maxheap) != 0 :
        heapq.heappush(minheap, int(heapq.heappop(maxheap)) * (-1))     # 최소정렬힙으로 전환 (양수 전환)

    return value 
