def solution(priorities, location):
    
    answer, temp_max, val = 0, 0, 0
    idxes = []
    
    idx = 0
    while idx < len(priorities) :
        
        idxes.append(idx)
        idx = idx + 1
    
    idx = 0
    while True :
        temp_max = max(priorities)
        val = priorities.pop(0)
        idx = idxes.pop(0)
        
        if val == temp_max :
            answer = answer + 1
            if idx == location :
                break
            else :
                continue
        else :
            priorities.append(val)
            idxes.append(idx)
        
    return answer
