#
#
#
#

def solution(array, commands):
    answer = []
    for que in commands :
        target_arr = array[(que[0] - 1):que[1]]
        target_arr.sort()
        answer.append(target_arr[que[2] - 1])
    return answer
