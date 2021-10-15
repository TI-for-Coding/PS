

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

    result[color] = result[color] + 1

N = int(input())
result = [0, 0, 0]
paper = [list(map(int, input().split(' '))) for i in range (N)]

search(0, 0, N)
print(result[-1])
print(result[0])
print(result[1])
