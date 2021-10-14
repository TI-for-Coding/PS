# 작성일 : 2021.10.06
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>스택/큐>다리를 지나는 트럭]
# 메모 : 파이썬의 리스트를 Queue 자료구조로 사용하였음.
#       (파이썬 달다!)

def solution(bridge_length, weight, truck_weights):
    
    answer = 0
    truck_ops_weight = []
    truck_ops_time = []
    
    while True :
        
        answer = answer + 1     # = time
        
        idx = 0
        for t in truck_ops_time :
            if truck_ops_time[idx] >= bridge_length :   # 다리를 지나는 트럭의 경우, idx 위치마다의 완료여부 확인
                truck_ops_weight.pop(0)                 # 다리를 지난 트럭을 pop()
                truck_ops_time.pop(0)
            else :
                idx = idx + 1
                
        if (len(truck_weights) != 0) :
            if (sum(truck_ops_weight) + truck_weights[0] <= weight) :   # 다리를 지나야 할 트럭의 경우, 다리를 지날 수 있는지 확인
                truck_ops_weight.append(truck_weights.pop(0))           # 다리를 지나야 할 트럭을 push() 
                truck_ops_time.append(0)
                
        idx = 0
        for t in truck_ops_time :                             # 다리를 지나는 트럭에 대해 일괄 시간 추가 (다리를 지난 시간)
            truck_ops_time[idx] = truck_ops_time[idx] + 1
            idx = idx + 1
            
        if (len(truck_weights) == 0) and (len(truck_ops_weight) == 0) : # 다리를 지나는 트럭, 다리를 지나야 할 트럭 모두 없으면, break
            break
        
    return answer
