# 작성일 : 2021.10.10
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>정렬>주식가격]
# 메모 : 문제가 조금 이상하다는 생각을 함. 
# 다른 케이스의 경우에는, 주식가격이 현 시점까지의 주식가격이 유지된 것으로 계산하는 데 반해, 
# 마지막의 케이스는 주식가격이 유지된 것이 아니므로 0 처리됨. 이에 대한 반례를 구상하는 데 시간이 걸렸음...
# 나머지는, 현재 가격으로부터 가격이 상승 or 유지되는 시간을 cnt로 구하여 answer에 append 

def solution(prices):

    answer = []

    for i in range(len(prices) - 1) :   # 특수 케이스를 위해 배열의 마지막은 대상 제외

        cnt = 0
        for j in range(i+1, len(prices)) :

            cnt = cnt + 1

            if prices[i] > prices[j] :  # 일반적일 케이스로는, 가격 하락 이전까지는 가격이 유지한 것으로 보고 마지막에 break 처리

                break

        answer.append(cnt)   # 현 시점으로부터 가격이 상승하는 시점까지 count한 값을 append

    answer.append(0)    # 특수 케이스를 위한 결과

    return answer
