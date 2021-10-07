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
