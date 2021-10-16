# 작성일 : 2021.10.16
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>완전탐색>소수 찾기]
# 메모 : 가능한 수의 조합을 만들기 위한 permute_number 메소드 작성 (permutations 모듈 활용)
#       solution 메소드 내에서는 소수 여부를 확인하기 위해 대상 값의 루트값에 대한 근사값까지 소수이면
#       대상 값은 소수임을 알 수 있으므로, sqrt(n)까지 나누어지는 값이 있는지 확인 (에라토스테네스의 체)


import math
from itertools import permutations


def solution(numbers):
    
    number_list = permute_number(numbers)
    answer = 0

    for n in number_list :

        switch = True

        for i in range (2, int(math.sqrt(n)) + 1) :     # 소수 판별 (에라토스테네스의 체)
            if n % i == 0 :
                switch = False
                break

        if switch == True :
            answer += 1

    return answer
  

def permute_number (num_list) :

    result = []
    result2 = []

    for i in range (1, len(num_list) + 1) :     # 가능한 모든 수의 조합 생성 (조합 결과가 '1'이거나, '0'으로 시작하는 경우는 아예 제외
        num = list(permutations(num_list, i))
        for n in num :
            temp = ''
            if n[0] != '0' :
                for i in range (len(n)) :
                    temp = temp + n[i]
                if temp != '1' :
                    result.append(int(temp))

    result.sort()

    for r in result :                           # 생성된 조합 내에서, 중복되는 항목은 모두 제거
        if len(result2) == 0 :
            result2.append(r)
        else :
            if result2[-1] != r :
                result2.append(r)

    return result2
