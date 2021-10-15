# 작성일 : 2021.10.14
# 언어 : Python
# 출처 : ACMICPC(백준) [1780번 : 종이의 개수]
# 메모 : 재귀 함수를 통한 분할과 정복으로 문제 풀이
#       1) 주어진 면적 (초기값은 N X N) 을 일일이 읽어가며, 동일한 색상인지 확인
#       2) 동일한 색상이 확인될 경우, result 배열에 +1
#       3) 다른 색상이 발견되었을 경우, 주어진 면적을 3분할하여, 1)번의 재귀 함수 수행 (주어진 면적인 N//3 X N//3)
#       4) 최종적으로 주어진 면적이 한 칸인 경우에는, for 문을 수행하지 않으므로 result 배열에 각각 +1

def search(x, y, N) :

    color = paper[x][y]

    for i in range (x, x + N) :
        for j in range(y, y + N) :
            if color != paper[i][j] :
                N = N//3
                for k in range (3) :
                    for l in range (3) :
                        search(x + k * N, y + l * N, N)
                return  # 여기서 계속 에러났었는데...다른 답안을 참고하였지만 확실히 이해하지 못했습니다ㅜㅜ
                        # 이해한 대로 정리하자면, 파이썬에서 사용되는 모든 함수식 (for, if, 사용자 정의함수 등등)은 최종적으로 return을 만났을 때,
                        # 결과값을 출력하는 의미도 있지만, 해당 함수를 호출한 배열으로 돌아간다는 의미이다.
                        # return이 없을 경우 : if color != paper[i][j] 발생 시 총 9번의 재귀함수를 수행한 후, if문을 재수행하는 문제 발생
                        # return이 있을 경우 : if 절에 구성된 모든 내용을 수행한 후, if문을 종료하고 다음 반복문을 수행

    result[color] = result[color] + 1

N = int(input())
result = [0, 0, 0]
paper = [list(map(int, input().split(' '))) for i in range (N)]

search(0, 0, N)

print(result[-1])
print(result[0])
print(result[1])
