# 작성일 : 2021.10.06
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>정렬>K번째수]
# 메모 : 파이썬의 리스트 substring 기능을 활용하여 풀었습니다

def solution(array, commands):
    answer = []
    for que in commands :
        target_arr = array[(que[0] - 1):que[1]]
        target_arr.sort()
        answer.append(target_arr[que[2] - 1])
    return answer
