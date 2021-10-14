# 작성일 : 2021.10.05
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>스택/큐>프린터]
# 메모 : 파이썬 List 구조를 활용한 Queue 자료구조 구현

def solution(priorities, location):
    
    answer, temp_max, val = 0, 0, 0     # 각각 최종값, 남은 작업 중 우선순위 최대값, 현재 작업대상의 우선순위값을 저장하는 변수
    idxes = []                          # 우선순위 리스트 (priorities) 의 작업 인덱스를 저장함.
    
    idx = 0
    while idx < len(priorities) :       # 인덱스 리스트 생성 (queue로 사용할 예정)
        
        idxes.append(idx)
        idx = idx + 1
    
    idx = 0
    while True :
        temp_max = max(priorities)      # 현 시점의 우선순위 최대값 저장
        val = priorities.pop(0)         # 현재 작업대상의 우선순위 저장
        idx = idxes.pop(0)              # 현재 작업대상의 기존 위치 저장
        
        if val == temp_max :            #작업순위가 최대값일 경우
            answer = answer + 1
            if idx == location :        # 조회대상일 경우, break
                break
            else :                      # 조회대상이 아닐경우, continue
                continue
        else :
            priorities.append(val)      # 작업순위가 최대값이 아닐 경우, 후순으로 append
            idxes.append(idx)
        
    return answer
