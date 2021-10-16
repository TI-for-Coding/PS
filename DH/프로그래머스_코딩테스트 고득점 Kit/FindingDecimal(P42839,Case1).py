import math
from itertools import permutations


def solution(numbers):
    
    number_list = permute_number(numbers)
    answer = 0

    for n in number_list :

        switch = True

        for i in range (2, int(math.sqrt(n)) + 1) :
            if n % i == 0 :
                switch = False
                break

        if switch == True :
            answer += 1

    return answer
  

def permute_number (num_list) :

    result = []
    result2 = []

    for i in range (1, len(num_list) + 1) :
        num = list(permutations(num_list, i))
        for n in num :
            temp = ''
            if n[0] != '0' :
                for i in range (len(n)) :
                    temp = temp + n[i]
                if temp != '1' :
                    result.append(int(temp))

    result.sort()

    for r in result :
        if len(result2) == 0 :
            result2.append(r)
        else :
            if result2[-1] != r :
                result2.append(r)

    return result2
