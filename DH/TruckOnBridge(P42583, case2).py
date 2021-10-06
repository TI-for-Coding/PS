def solution(bridge_length, weight, truck_weights):
    
    answer = 0
    truck_ops_weight = []
    truck_ops_time = []
    
    while True :
        
        answer = answer + 1
        
        idx = 0
        for t in truck_ops_time :
            if truck_ops_time[idx] >= bridge_length :
                truck_ops_weight.pop(0)
                truck_ops_time.pop(0)
            else :
                idx = idx + 1
                
        if (len(truck_weights) != 0) :
            if (sum(truck_ops_weight) + truck_weights[0] <= weight) :
                truck_ops_weight.append(truck_weights.pop(0))
                truck_ops_time.append(0)
                
        idx = 0
        for t in truck_ops_time :
            truck_ops_time[idx] = truck_ops_time[idx] + 1
            idx = idx + 1
            
        if (len(truck_weights) == 0) and (len(truck_ops_weight) == 0) :
            break
        
    return answer
