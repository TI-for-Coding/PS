# 작성일 : 2021.10.16
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>완전탐색>카펫]
# 메모 : yellow 영역의 특징을 find_multiple_case로 탐색.
#       brown 영역의 특징을 find_add_case로 탐색.
#       주어진 값에 대한 경우의 수는 오직 1개이므로, 결과 찾으면 바로 종료 및 결과 출력


def solution(brown, yellow):
  
    answer = find_add_case(find_multiple_case(yellow), brown)   # Yellow 의 경우의 수 (여러 개) 를 찾고, 이를 brown 경우의 수에 각각 대입 
    
    return answer


def find_multiple_case(number) :    # yellow 경우의 수를 찾음. 

    y = 1
    answer = []

    while y <= number / y :         # 가로가 더 긴 경우에서, 곱셈을 통해 면적의 크기가 number가 되는 모든 경우룰 찾음.
        if number % y == 0 :
            x = number // y
            answer.append([x, y])
        y = y + 1

    return answer


def find_add_case (grid, number) :  # brown 경우의 수를 찾음.

    answer = []

    for g in grid :                 # yellow 에서 발생하는 각 케이스마다, brown 의 가로, 세로 길이를 각각 x, y로 치환

        x = g[0] + 2
        y = g[1] + 2

        if (x + y) * 2 - 4 == number :   # 해당 케이스가 주어진 number와 일치할 수 있는지 확인
            answer += [x, y]
            break

    return answer
