# 작성일 : 2021.11.28
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>찾아라 프로그래밍 마에스터>폰켓몬]
# 메모 : 최적의 프로그래밍은 아닌듯!

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
