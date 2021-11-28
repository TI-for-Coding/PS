def solution(nums):
    
    pocket_size = int(len(nums) / 2)
    
    nums.sort()
    tgt = -1
    answer = 0
    
    while nums :
        
        n = nums.pop(0)
        
        if (tgt == -1) or (tgt != n) :
            tgt = n
            answer = answer + 1
            
        if answer >= pocket_size :
            break
            
    return answer
